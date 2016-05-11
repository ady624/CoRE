/**
 *  CoRE - Community's own Rule Engine
 *
 *  Copyright 2016 Adrian Caramaliu
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Version history
 *   5/11/2016 >>> v0.0.005.20160511 - Alpha test version - Changed name from "Rule Engine" to "CoRE" and added an easter egg
 *   5/10/2016 >>> v0.0.004.20160510 - Alpha test version - Added runtime statistics - even more stats for nerds
 *   5/10/2016 >>> v0.0.003.20160510 - Alpha test version - Added runtime statistics - stats for nerds
 *   5/10/2016 >>> v0.0.001.20160510 - Alpha test version - Minor improvements for global variable list
 *   5/10/2016 >>> v0.0.000.20160510 - Alpha test version - Initial build
 *
 */
definition(
    name: "CoRE",
    namespace: "ady624",
    author: "Adrian Caramaliu",
    description: "CoRE - Community's own Rule Engine",
    singleInstance: true,
    category: "Convenience",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")

def version() {
	return "v0.0.005.20160511"
}

def mem() {
	def bytes = state.toString().length()
	return Math.round(100.00 * (bytes/ 100000.00)) + "% ($bytes bytes)"
}

preferences {
	page(name: "pageMain")
    page(name: "pageVariables")
    page(name: "pageStatistics")
    page(name: "pageChart")
}

def pageMain() {
	dynamicPage(name: "pageMain", title: "CoRE - Pistons", install: true, uninstall: true) {
        section {
            app( name: "pistons", title: "Add a piston...", description: "test", appName: "CoRE Piston", namespace: "ady624", , multiple: true)
        }

        section(title:"Application Info") {
        	paragraph version(), title: "Version"
			href "pageVariables", title: "Global Variables"
			href "pageStatistics", title: "Runtime Statistics"
        }

		section(title: "Advanced options", hideable: true, hidden: true) {
        	input "expertMode", "bool", title: "Expert Mode", defaultValue: false
        	input "debugging", "bool", title: "Enable debugging", defaultValue: false
		}
        
    }
}

def pageVariables() {
	dynamicPage(name: "pageVariables", title: "Global Variables", install: false, uninstall: false) {
    	section() {
            for (def variable in state.store) {
            	def value = variable.value
                if ((value instanceof Long) && (value > 999999999999)) {
                	value = formatLocalTime(value)
                }
                paragraph "$value", title: "${variable.key}"
            }
        }
	}
}

def pageStatistics() {
	dynamicPage(name: "pageStatistics", title: "", install: false, uninstall: false) {
        def apps = getChildApps()
    	section(title: "CoRE") {
            paragraph mem(), title: "Memory Usage"
            paragraph "${apps.size}", title: "Running pistons"
            paragraph "0", title: "Paused pistons"
            paragraph "${apps.size}", title: "Total pistons"
        }
        
        updateChart("delay", null)
        section(title: "Event delay (15 minute average, last 2h)") {
        	def text = ""
            def chart = state.charts["delay"]
            def totalAvg = 0
            for (def i = 0; i < 8; i++) {
            	def value = Math.ceil((chart["$i"].c ? chart["$i"].t / chart["$i"].c : 0) / 100) / 10
                def time = chart["$i"].q
                def hour = time.mod(3600000) == 0 ? formatLocalTime(time, "h a") : "\t"
            	def avg = Math.ceil(value / 6)
                totalAvg += avg
                if (avg > 10) {
                	avg = 10
                }
                def graph = avg == 0 ? "X" : "".padLeft(avg, "■") + " ${value}s"
            	text += "$hour\t${graph}\n"
            }
            totalAvg = totalAvg / 8
            href "pageChart", params: [chart: "delay", title: "Event delay"], title: "", description: text, required: true, state: totalAvg < 5 ? "complete" : null
        }

        updateChart("exec", null)
        section(title: "Execution time (15 minute average, last 2h)") {
        	def text = ""
            def chart = state.charts["exec"]
            def totalAvg = 0
            for (def i = 0; i < 8; i++) {
            	def value = Math.ceil((chart["$i"].c ? chart["$i"].t / chart["$i"].c : 0) / 100) / 10
                def time = chart["$i"].q
                def hour = time.mod(3600000) == 0 ? formatLocalTime(time, "h a") : "\t"
            	def avg = Math.ceil(value / 6)
                totalAvg += avg
                if (avg > 10) {
                	avg = 10
                }
                def graph = avg == 0 ? "X" : "".padLeft(avg, "■") + " ${value}s"
            	text += "$hour\t${graph}\n"
            }
            totalAvg = totalAvg / 8
            href "pageChart", params: [chart: "exec", title: "Execution time"], title: "", description: text, required: true, state: totalAvg < 5 ? "complete" : null
        }

		def i = 0
        if (apps && apps.size()) {
            for (app in apps) {
                def mode = app.getMode()
                def version = app.version()
                def currentState = app.getCurrentState()
                def stateSince = app.getCurrentStateSince()
                def runStats = app.getRunStats()
                def conditionStats = app.getConditionStats()
                def subscribedDevices = app.getDeviceSubscriptionCount()
                stateSince = stateSince ? formatLocalTime(stateSince) : null
                def description = "Piston mode: ${mode ? mode : "unknown"}"
                description += "\nPiston version: $version"
                description += "\nSubscribed devices: $subscribedDevices"
                description += "\nCondition count: ${conditionStats.conditions}"
                description += "\nTrigger count: ${conditionStats.triggers}"
                description += "\n\nCurrent state: ${currentState == null ? "unknown" : currentState}"
                description += "\nSince: " + (stateSince ?  stateSince : "(never run)")
                description += "\n\nMemory usage: " + app.mem()
                if (runStats) {
	                def executionSince = runStats.executionSince ? formatLocalTime(runStats.executionSince) : null
                    description += "\n\nEvaluated: ${runStats.executionCount} time${runStats.executionCount == 1 ? "" : "s"}"
                    description += "\nSince: " + (executionSince ?  executionSince : "(unknown)")
                    description += "\n\nTotal evaluation time: ${Math.round(runStats.executionTime / 1000)}s"
                    description += "\nLast evaluation time: ${runStats.lastExecutionTime}ms"
                    if (runStats.executionCount > 0) {
                        description += "\nMin evaluation time: ${runStats.minExecutionTime}ms"
                        description += "\nAvg evaluation time: ${Math.round(runStats.executionTime / runStats.executionCount)}ms"
                        description += "\nMax evaluation time: ${runStats.maxExecutionTime}ms"
                    }
                    if (runStats.eventDelay) {
                        description += "\n\nLast event delay: ${runStats.lastEventDelay}ms"
                        if (runStats.executionCount > 0) {
                            description += "\nMin event delay time: ${runStats.minEventDelay}ms"
                            description += "\nAvg event delay time: ${Math.round(runStats.eventDelay / runStats.executionCount)}ms"
                            description += "\nMax event delay time: ${runStats.maxEventDelay}ms"
                        }
					}                    
                }
                section(title: i++ == 0 ? "Pistons" : "") {
                    paragraph description, title: app.label ? app.label : app.name, required: currentState != null, state: currentState ? "complete" : null
                }
            }
        } else {
        	section() {
            	paragraph "No pistons running"
            }
        }
    }
}

def pageChart(params) {
	def chartName = params?.chart
    def chartTitle = params?.title
	dynamicPage(name: "pageChart", title: "", install: false, uninstall: false) {
    	if (chartName) {
            updateChart(chartName, null)
            section(title: "$chartTitle (15 minute average, last 24h)\nData is calculated across all pistons") {
                def text = ""
                def chart = state.charts[chartName]
				def totalAvg = 0
                for (def i = 0; i < 96; i++) {
                    def value = Math.ceil((chart["$i"].c ? chart["$i"].t / chart["$i"].c : 0) / 100) / 10
                    def time = chart["$i"].q
                    def hour = time.mod(3600000) == 0 ? formatLocalTime(time, "h a") : "\t"
                    def avg = Math.ceil(value / 6)
	                totalAvg += avg
                    if (avg > 10) {
                        avg = 10
                    }
                    def graph = avg == 0 ? "X" : "".padLeft(avg, "■") + " ${value}s"
                    text += "$hour\t${graph}\n"
                }
				totalAvg = totalAvg / 96
                paragraph text, required: true, state: totalAvg < 5 ? "complete" : null
            }
		}
    }
}

def installed() {
	log.debug "Installed with settings: ${settings}"

	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	initialize()
}

def initialize() {
	// TODO: subscribe to attributes, devices, locations, etc.
    if (state.store == null) {
    	state.store = [:]
    }
}

def getVariable(name) {
	return state.store[name]
}

def setVariable(name, value) {
	state.store[name] = value
    //TODO: date&time triggers based on variables being changed need to be reevaluated
}

def listVariables() {
	def result = []
    for (variable in state.store) {
    	result.push(variable.key)
    }
    return result.sort()
}

def expertMode() {
	return !!settings["expertMode"]
}

def logEventDelay(delay) {
	updateChart("delay", delay)
    return true
}

//adjusts the time to local timezone
private adjustTime(time) {
	if (time instanceof String) {
    	//get UTC time
    	time = timeToday(time, location.timeZone).getTime()
    }
    if (time instanceof Date) {
    	//get unix time
    	time = time.getTime()
    }
    if (time) {
    	return new Date(time + location.timeZone.getOffset(time))
    }
    return null
}

private formatLocalTime(time, format = "EEE, MMM d yyyy @ h:mm a z") {
	if (time instanceof Long) {
    	time = new Date(time)
    }
	if (!(time instanceof Date)) {
    	return null
    }
	def formatter = new java.text.SimpleDateFormat(format)
	formatter.setTimeZone(location.timeZone)
	return formatter.format(time)
}

private getPreviousQuarterHour(unixTime = now()) {
	return unixTime - unixTime.mod(900000)
}

def updateChart(name, value) {
	def charts = atomicState.charts
    charts = charts ? charts : [:]
    def modified = false
    def lastQuarter = getPreviousQuarterHour()
    def chart = charts[name]
    if (!chart) {
    	//create a log with that name
        chart = [:]
        //create the log for the last 96 quarter-hours
        def quarter = lastQuarter
        for (def i = 0; i < 96; i++) {
        	chart["$i"] = [q: quarter, t: 0, c: 0]
            //chart["q$i"].q = quarter
            //chart["q$i"].t = 0
            //chart["q$i"].c = 0
            quarter = quarter - 900000
        }
        charts[name] = chart
        modified = true
    }
    if (lastQuarter != chart["0"].q) {
    	//we need to advance the log
        def steps = Math.floor((lastQuarter - chart["0"].q) / 900000).toInteger()
        if (steps != 0) {
        	modified = true
        	//we need to shift the log, we're in a different current quarter
            if ((steps < 1) || (steps > 95)) {
            	//in case of weird things, we reset the whole log
                steps = 96
            }
            if (steps < 96) {
                //reset the log as it seems we have a problem
                for (def i = 95; i >= steps; i--) {
                    chart["$i"] = chart["${i-steps}"]
                    //chart["q$i"].q = chart["q${i-steps}"].q
                    //chart["q$i"].c = chart["q${i-steps}"].c
                    //chart["q$i"].t = chart["q${i-steps}"].t
                }
            }
            //reset the new quarters
            def quarter = lastQuarter
            for (def i = 0; i < steps; i++) {
                chart["$i"] = [q: quarter, t: 0, c:0]
                //chart["q$i"].t = 0
                //chart["q$i"].c = 0
                quarter = quarter - 900000
            }        	
        }
    }
    if (value) {
    	modified = true
        chart["0"].t = chart["0"].t + value
        chart["0"].c = chart["0"].c + 1
    }
    if (modified) {
    	charts[name] = chart
	    //state.charts = charts
        //atomicState.charts = charts
        state.charts[name] = chart
        atomicState.charts[name] = chart
    }
   	return null
}