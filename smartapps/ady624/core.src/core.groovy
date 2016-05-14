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
 *	 5/14/2016 >>> v0.0.019.20160514 - Alpha test version - Bug fixes - event cache not properly initialized leading to impossibility to install a new piston, more action UI progress
 *	 5/14/2016 >>> v0.0.018.20160514 - Alpha test version - Fixed minor bugs with time formatting and trigger calculations, fixed variables not set on time triggers
 *	 5/13/2016 >>> v0.0.017.20160513 - Alpha test version - Variable support improved - full list of variables during config
 *	 5/13/2016 >>> v0.0.016.20160513 - Alpha test version - Minor fixes, bringing missing methods back from the dead
 *	 5/13/2016 >>> v0.0.015.20160513 - Alpha test version - Merged CoRE and CoRE Piston into one single its-own-parent-and-child app, action UI progress
 * 
 *******************************************************************************************************************************************************************
 * PLEASE MAKE SURE TO UNINSTALL ANY PREVIOUS VERSION UP UNTIL HERE - CHILD NAME HAS CHANGED
 *******************************************************************************************************************************************************************
 * 
 *  CoRE version history before merge
 *	 5/11/2016 >>> v0.0.005.20160511 - Alpha test version - Changed name from "Rule Engine" to "CoRE" and added an easter egg
 *	 5/10/2016 >>> v0.0.004.20160510 - Alpha test version - Added runtime statistics - even more stats for nerds
 *	 5/10/2016 >>> v0.0.003.20160510 - Alpha test version - Added runtime statistics - stats for nerds
 *	 5/10/2016 >>> v0.0.001.20160510 - Alpha test version - Minor improvements for global variable list
 *	 5/10/2016 >>> v0.0.000.20160510 - Alpha test version - Initial build
 * 
 *  CoRE Piston version history before merge
 *   5/12/2016 >>> v0.0.014.20160512 - Alpha test version - Piston's scheduler, "Timing belt" is now operational.
 *   5/11/2016 >>> v0.0.013.20160511 - Alpha test version - Name changed to CoRE Piston, child of CoRE, time triggers operational - can figure out next schedule time
 *   5/10/2016 >>> v0.0.012.20160510 - Alpha test version - Added runtime statistics - even more stats for nerds
 *   5/10/2016 >>> v0.0.011.20160510 - Alpha test version - Added runtime statistics - stats for nerds
 *   5/10/2016 >>> v0.0.010.20160510 - Alpha test version - Minor improvements for global variable list
 *   5/10/2016 >>> v0.0.00f.20160510 - Alpha test version - Local and global (@) variables support, added offsets for device and variable comparison
 *   5/10/2016 >>> v0.0.00e.20160510 - Alpha test version - Time condition evaluation done, filters pending
 *   5/10/2016 >>> v0.0.00d.20160510 - Alpha test version - Date & Time condition UI tweaks, time interpretation complete
 *   5/07/2016 >>> v0.0.00c.20160507 - Alpha test version - Date & Time condition UI tweaks
 *   5/07/2016 >>> v0.0.00b.20160507 - Alpha test version - Date & Time condition UI finalized, pending community comments
 *   5/07/2016 >>> v0.0.00a.20160507 - Alpha test version - Name changed to Piston, child app of Rule Engine, courtesy of @bridaus and @JDRoberts (reinforcement of the word Rule)
 *   5/06/2016 >>> v0.0.009.20160506 - Alpha test version - Partial support for Location Mode, Smart Home Monitor and Date & Time - work in progress
 *   5/06/2016 >>> v0.0.008.20160506 - Alpha test version - Minor improvements
 *   5/05/2016 >>> v0.0.007.20160505 - Alpha test version - All conditions implemented, simple triggers implemented. History-based triggers ("...stays...") not working yet
 *   5/05/2016 >>> v0.0.006.20160505 - Alpha test version - Simple conditions implemented. All "is" type conditions should work
 *   5/04/2016 >>> v0.0.005.20160504 - Alpha test version - added full list of standard capabilities, attributes and commands, improved condition UI
 *   5/02/2016 >>> v0.0.004.20160502 - Alpha test version - changed license from Apache to GPLv3
 *   5/02/2016 >>> v0.0.003.20160502 - Alpha test version - added mode - simple, latching or else-if
 *   5/02/2016 >>> v0.0.002.20160502 - Alpha test version - added latching rules
 *   4/29/2016 >>> v0.0.001.20160429 - Alpha test version - added condition naming
 *   4/29/2016 >>> v0.0.000.20160429 - Alpha test version
 *
 */


/******************************************************************************/
/*** CoRE VERSION															***/
/******************************************************************************/

def version() {
	return "v0.0.019.20160514"
}


/******************************************************************************/
/*** CoRE DEFINITION														***/
/******************************************************************************/

definition(
    name: "CoRE${parent ? " - Piston" : ""}",
    namespace: "ady624",
    author: "Adrian Caramaliu",
    description: "CoRE - Community's own Rule Engine",
    singleInstance: true,
    category: "Convenience",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png"
)

preferences {
	//common pages
	page(name: "pageMain")
    
    //CoRE pages
    page(name: "pageStatistics")
    page(name: "pageChart")
    page(name: "pageGlobalVariables")
    
    //Piston pages
    page(name: "pageIf")
    page(name: "pageIfOther")
    page(name: "pageThen")
    page(name: "pageElse")
    page(name: "pageCondition")
    page(name: "pageConditionGroupL1")
    page(name: "pageConditionGroupL2")
    page(name: "pageConditionGroupL3")
    page(name: "pageConditionVsTrigger")
    page(name: "pageActionGroup")
    page(name: "pageAction")
    page(name: "pageActionDevices")
    page(name: "pageVariables")    
}


/******************************************************************************/
/*** CoRE CONSTANTS															***/
/******************************************************************************/

private triggerPrefix() {
    return "● "
}

private conditionPrefix() {
	return "◦ "
}

private virtualCommandPrefix() {
    return "● "
}

private customAttributePrefix() {
	return "⌂ "
}

private customCommandPrefix() {
	return "⌂ "
}

private customCommandSuffix() {
	return "(..)"
}

/******************************************************************************/
/*** 																		***/
/*** CONFIGURATION PAGES													***/
/*** 																		***/
/******************************************************************************/


/******************************************************************************/
/*** COMMON PAGES															***/
/******************************************************************************/
def pageMain() {
	if (!parent) {
		pageMainCoRE()
    } else {
		pageMainCoREPiston()
    }
}


/******************************************************************************/
/*** CoRE PAGES																***/
/******************************************************************************/
private pageMainCoRE() {
    //CoRE main page
    dynamicPage(name: "pageMain", title: "CoRE Pistons", install: true, uninstall: true) {
        section {
            app( name: "pistons", title: "Add a CoRE piston...", appName: "CoRE", namespace: "ady624", multiple: true)
        }

        section(title:"Application Info") {
            paragraph version(), title: "Version"
            href "pageGlobalVariables", title: "Global Variables"
            href "pageStatistics", title: "Runtime Statistics"
        }

        section(title: "Advanced options", hideable: true, hidden: true) {
            input "expertMode", "bool", title: "Expert Mode", defaultValue: false
            input "debugging", "bool", title: "Enable debugging", defaultValue: false
        }

    }
}

def pageGlobalVariables() {
	dynamicPage(name: "pageGlobalVariables", title: "Global Variables", install: false, uninstall: false) {
    	section() {
        	def cnt = 0
            for (def variable in state.store.sort{ it.key }) {
            	def value = getVariable(variable.key)
                if ((value instanceof Long) && (value > 999999999999)) {
                	value = formatLocalTime(value)
                }
                paragraph "$value", title: "${variable.key}"
                cnt++
            }
            if (!cnt) {
            	paragraph "No global variables yet"
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
            	def avg = Math.ceil(value / 1)
                totalAvg += avg
                if (avg > 10) {
                	avg = 10
                }
                def graph = avg == 0 ? "□" : "".padLeft(avg, "■") + " ${value}s"
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
            	def avg = Math.ceil(value / 1)
                totalAvg += avg
                if (avg > 10) {
                	avg = 10
                }
                def graph = avg == 0 ? "□" : "".padLeft(avg, "■") + " ${value}s"
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
                    def avg = Math.ceil(value / 1)
	                totalAvg += avg
                    if (avg > 10) {
                        avg = 10
                    }
                    def graph = avg == 0 ? "□" : "".padLeft(avg, "■") + " ${value}s"
                    text += "$hour\t${graph}\n"
                }
				totalAvg = totalAvg / 96
                paragraph text, required: true, state: totalAvg < 5 ? "complete" : null
            }
		}
    }
}




/******************************************************************************/
/*** CoRE PISTON PAGES														***/
/******************************************************************************/

private pageMainCoREPiston() {
    //CoRE Piston main page
    dev()
    state.run = "config"
    configApp()
    cleanUpConditions(true)
    dynamicPage(name: "pageMain", title: "", uninstall: true, install: true) {
    	def currentState = state.currentState
    	section() {
        	def enabled = settings["enabled"] != false
        	input "enabled", "bool", description: enabled ? "Current state: ${currentState == null ? "unknown" : currentState}\nCPU: ${cpu()}\t\tMEM: ${mem(false)}" : "", title: "Status: ${enabled ? "RUNNING" : "PAUSED"}", submitOnChange: true, required: false, state: "complete", defaultValue: true
            input "mode", "enum", title: "Piston Mode", required: true, state: null, options: ["Simple", "Latching", "Else-If"], defaultValue: "Simple", submitOnChange: true
            switch (settings.mode) {
                case "Latching":
                paragraph "A latching Piston - also known as a bi-stable Piston - uses one set of conditions to achieve a 'true' state and a second set of conditions to revert back to its 'false' state"
                break
                case "Else-If":
                paragraph "An Else-If Piston executes a set of actions if an initial condition set evaluates to true, otherwise executes a second set of actions if a second condition set evaluates to true"
                break
            }
        }
        section() {
            href "pageIf", title: "If...", description: (state.config.app.conditions.children.size() ? "Tap here to edit the main If group or tap on any individual conditions below to edit them directly" : "Tap to select conditions")
            buildIfContent()
        }

        section() {
            href "pageActionGroup", params:[conditionId: 0], title: "Then...", description: "Choose what should happen then", state: null, submitOnChange: false
        }

        if (settings.mode == "Latching") {
            section() {
                href "pageIfOther", title: "But if...", description: (state.config.app.otherConditions.children.size() ? "" : "Tap to select conditions")
                buildIfOtherContent()
            }
        }

        if (settings.mode == "Else-If") {
            section() {
                href "pageIfOther", title: "Else if...", description: (state.config.app.otherConditions.children.size() ? "" : "Tap to select conditions")
                buildIfOtherContent()
            }
        }

        section() {
            href "pageActionGroup", params:[conditionId: -1], title: ((settings.mode == "Latching") || (settings.mode == "Else-If") ? "Then..." : "Else..."), description: "Choose what should happen otherwise", state: null, submitOnChange: false
        }

        section() {
            href "pageSimulate", title: "Simulate", description: "Allows you to test the actions manually", state: complete
        }

        section(title:"Application Info") {
            label name: "name", title: "Name", required: true, state: (name ? "complete" : null), defaultValue: parent.generatePistonName()
            input "description", "string", title: "Description", required: false, state: (description ? "complete" : null), capitalization: "sentences"
            paragraph version(), title: "Version"
            paragraph mem(), title: "Memory Usage"
            href "pageVariables", title: "Local Variables"
        }
        
        section(title: "Advanced options", hideable: true, hidden: true) {
            input "debugging", "bool", title: "Enable debugging", defaultValue: false, submitOnChange: true
        }
    }
}

def pageIf(params) {
    state.run = "config"
	cleanUpConditions(false)
	def condition = state.config.app.conditions
    dynamicPage(name: "pageIf", title: "Main Condition Group", uninstall: false, install: false) {
    	getConditionGroupPageContent(params, condition)
    }
}

def pageIfOther(params) {
    state.run = "config"
    cleanUpConditions(false)
	def condition = state.config.app.otherConditions
    dynamicPage(name: "pageIfOther", title: "Main Group", uninstall: false, install: false) {
    	getConditionGroupPageContent(params, condition)
    }
}
def pageConditionGroupL1(params) {
	pageConditionGroup(params, 1)
}

def pageConditionGroupL2(params) {
	pageConditionGroup(params, 2)
}

def pageConditionGroupL3(params) {
	pageConditionGroup(params, 3)
}

//helper function for condition group paging
def pageConditionGroup(params, level) {
    state.run = "config"
    cleanUpConditions(false)
    def condition = null    
    if (params?.command == "add") {
        condition = createCondition(params?.parentConditionId, true)
    } else {
		condition = getCondition(params?.conditionId ? params?.conditionId : state.config["conditionGroupIdL$level"])
    }
    if (condition) {
    	def id = condition.id
        state.config["conditionGroupIdL$level"] = id
        def pid = condition.parentId
    	dynamicPage(name: "pageConditionGroupL$level", title: "Group $id (level $level)", uninstall: false, install: false) {
	    	getConditionGroupPageContent(params, condition)
	    }
    }
}

private getConditionGroupPageContent(params, condition) {	
	if (condition) {
        def id = condition.id
        def pid = condition.parentId ? condition.parentId : condition.id
        def nextLevel = (condition.level ? condition.level : 0) + 1
        def cnt = 0
        section() {
        	if (settings["condNegate$id"]) {
                paragraph "NOT ("
            }
            for (c in condition.children) {
            	if (cnt > 0) {
                	if (cnt == 1) {
			           	input "condGrouping$id", "enum", title: "", description: "Choose the logical operation to be applied between all conditions in this group", options: ["AND", "OR", "XOR"], defaultValue: "AND", required: true, submitOnChange: true
                    } else {
                		paragraph settings["condGrouping$id"], state: "complete"
                    }
                }
                def cid = c?.id
		        def conditionType = (c.trg ? "trigger" : "condition")
                if (c.children != null) {
                    href "pageConditionGroupL${nextLevel}", /*image: "https://raw.githubusercontent.com/ady624/SmartThingers/master/resources/images/folder.png",*/ params: ["conditionId": cid], title: "Group #$cid", description: getConditionDescription(cid), state: "complete", required: false, submitOnChange: false
                } else {
                    href "pageCondition", /*image: "https://raw.githubusercontent.com/ady624/SmartThingers/master/resources/images/${conditionType}.png",*/ params: ["conditionId": cid], title: (c.trg ? "Trigger" : "Condition") + " #$cid", description: getConditionDescription(cid), state: "complete", required: false, submitOnChange: false
                }
                cnt++
            }
        	if (settings["condNegate$id"]) {
                paragraph ")", state: "complete"
            }
        }
        section() {
            href "pageCondition", params:["command": "add", "parentConditionId": id], title: "Add a condition", description: "A condition watches the state of one or multiple similar devices", state: "complete", submitOnChange: true
            //href "pageCondition", params:["command": "add", "parentConditionId": id], title: "Add a trigger", description: "A trigger is a specialised condition that watches for state changes of one or multiple similar devices", state: "complete", submitOnChange: true
            if (nextLevel <= 3) {
            	href "pageConditionGroupL${nextLevel}", params:["command": "add", "parentConditionId": id], title: "Add a group", description: "A group is a container for multiple conditions and/or triggers, allowing for more complex logical operations, such as evaluating [A AND (B OR C)]", state: "complete", submitOnChange: true
            }
        }
        
        if (condition.children.size()) {
            section(title: "Group Overview") {
                paragraph getConditionDescription(id)
                href "pageActionGroup", params:[conditionId: id], title: "Individual actions", description: "Tap to set individual actions for this condition", state: complete, submitOnChange: true
            }       
		}
//        section() {
//            href "pageConditionVsTrigger", title: "Uh oh, which should I use?", description: "Find out when to use a condition and when to use a trigger", state: complete, submitOnChange: false
//        }

		section(title: "Advanced options", hideable: true, hidden: true) {
           	//input "condGrouping$id", "enum", title: "Grouping Method", description: "Choose the logical operation to be applied between all conditions in this group", options: ["AND", "OR", "XOR"], defaultValue: "AND", required: true, submitOnChange: true
           	input "condNegate$id", "bool", title: "Negate Group", description: "Apply a logical NOT to the whole group", defaultValue: false, required: true, submitOnChange: true
        }

		if (id) {
            section(title: "Required data - do not change", hideable: true, hidden: true) {            
                input "condParent$id", "number", title: "Parent ID", description: "Value needs to be $pid, do not change", range: "$pid..$pid", defaultValue: pid
			}
        }
    }
}

def pageCondition(params) {
	state.run = "config"
	//get the current edited condition
    def condition = null
    if (params?.command == "add") {
        condition = createCondition(params?.parentConditionId, false)
    } else {   	
		condition = getCondition(params?.conditionId ? params?.conditionId : state.config.conditionId)
    }
    if (condition) {
    	updateCondition(condition)
    	def id = condition.id
        state.config.conditionId = id
        def pid = condition.parentId
        def showDateTimeFilter = false
        def showDateTimeRepeat = false
        def recurring = false
        def trigger = false
    	dynamicPage(name: "pageCondition", title: (condition.trg ? "Trigger" : "Condition") + " #$id", uninstall: false, install: false) {
			section() {
            	if (!settings["condDevices$id"] || (settings["condDevices$id"].size() == 0)) {
                	//only display capability selection if no devices already selected
	            	input "condCap$id", "enum", title: "Capability", options: listCapabilities(true, false), submitOnChange: true, required: false
                }
                if (settings["condCap$id"]) {
                	def capability = getCapabilityByDisplay(settings["condCap$id"])
                    if (capability) {
                    	if (capability.virtualDevice) {
                        	def attribute = capability.attribute
                            def attr = getAttributeByName(attribute)
                            if (attribute == "time") {
                            	//Date & Time support
                                def comparison = cleanUpComparison(settings["condComp$id"])
                                input "condComp$id", "enum", title: "Comparison", options: listComparisonOptions(attribute, true), required: true, multiple: false, submitOnChange: true
                                if (comparison) {
									def comp = getComparisonOption(attribute, comparison)
                                    if (attr && comp) {
                                        //we have a valid comparison object
                                        trigger = (comp.trigger == comparison)
                                        //if no parameters, show the filters
                                        def varList = listVariables(true)
                                        showDateTimeFilter = comp.parameters == 0
                                        for (def i = 1; i <= comp.parameters; i++) {
                                            input "condValue$id#$i", "enum", title: (comp.parameters == 1 ? "Value" : (i == 1 ? "Time" : "And")), options: timeComparisonOptionValues(trigger), required: true, multiple: false, submitOnChange: true
                                            def value = settings["condValue$id#$i"]
                                            if (value) {
												showDateTimeFilter = true
                                                if (value.contains("custom")) {
                                                    //using a time offset
                                                    input "condTime$id#$i", "time", title: "Custom time", required: true, multiple: false, submitOnChange: true
                                                }
                                                if (value.contains("variable")) {
                                                    //using a time offset
                                                    input "condVar$id#$i", "enum", options: varList, title: "Variable", required: true, multiple: false, submitOnChange: true
                                                }
                                                if (comparison.contains("around") || !(value.contains('every') || value.contains('custom'))) {
                                                    //using a time offset
                                                    input "condOffset$id#$i", "number", title: (comparison.contains("around") ? "Give or take minutes" : "Offset (+/- minutes)"), range: (comparison.contains("around") ? "1..360" : "-360..360"), required: true, multiple: false, defaultValue: (comparison.contains("around") ?  5 : 0), submitOnChange: true
                                                }

												if (value.contains("minute")) {
                                                	recurring = true
                                                }

                                                if (value.contains("number")) {                                              
                                                    //using a time offset
                                                    input "condEvery$id", "number", title: value.replace("every n", "N"), range: "1..*", required: true, multiple: false, defaultValue: 5, submitOnChange: true
                                                    recurring = true
                                                }
                                                
												if (value.contains("hour")) {
                                                    //using a time offset
                                                    input "condMinute$id", "enum", title: "At this minute", options: timeMinuteOfHourOptions(), required: true, multiple: false, submitOnChange: true
                                                    recurring = true
                                                }
                                                
                                            }
                                        }
                                        if (trigger && !recurring) {
											showDateTimeRepeat = true
                                        }
                                    }
                                }
                            
                            } else {
                            	//Location Mode, Smart Home Monitor support
                                def comparison = cleanUpComparison(settings["condComp$id"])
                                input "condComp$id", "enum", title: "Comparison", options: listComparisonOptions(attribute, true), required: true, multiple: false, submitOnChange: true                                
                                if (comparison) {                                	
                                    //Value
                                    def comp = getComparisonOption(attribute, comparison)
                                    if (attr && comp) {
                                    	trigger = (comp.trigger == comparison)
                                        if (comp.parameters >= 1) {
                                            input "condValue$id#1", attr.type, title: "Value", options: attr.options, range: attr.range, required: true, multiple: comp.multiple, submitOnChange: true
                                        }
                                    }
                                }
							}
                        } else {                        
                        	//physical device support
                            def devices = settings["condDevices$id"]
                            input "condDevices$id", "capability.${capability.name}", title: "${capability.display} list", required: false, state: (devices ? "complete" : null), multiple: capability.multiple, submitOnChange: true
                            if (devices && devices.size()) {
                                if (!condition.trg && (devices.size() > 1)) {
                                    input "condMode$id", "enum", title: "Evaluation mode", options: ["Any", "All"], required: true, multiple: false, defaultValue: "All", submitOnChange: true
                                }
                                def evalMode = (settings["condMode$id"] == "All" && !condition.trg) ? "All" : "Any"

                                //Attribute
                                def attribute = cleanUpAttribute(settings["condAttr$id"])
                                if (attribute == null) {
                                    attribute = capability.attribute
                                }
                                //display the Attribute only in expert mode or in basic mode if it differs from the default capability attribute
                                if ((attribute != capability.attribute) || state.config.expertMode) {
                                    input "condAttr$id", "enum", title: "Attribute", options: listCommonDeviceAttributes(devices), required: true, multiple: false, defaultValue: capability.attribute, submitOnChange: true
                                }
                                if (attribute) {                              
                                    //Condition
                                    def attr = getAttributeByName(attribute)
                                    def comparison = cleanUpComparison(settings["condComp$id"])
                                    input "condComp$id", "enum", title: "Comparison", options: listComparisonOptions(attribute, true), required: true, multiple: false, submitOnChange: true                                
                                    if (comparison) {                                	
                                        //Value
                                        def comp = getComparisonOption(attribute, comparison)
                                        if (attr && comp) {
                                        	trigger = (comp.trigger == comparison)                                            
                                            def extraComparisons = !comparison.contains("one of")
                                            def varList = (extraComparisons ? listVariables(true) : [])
                                            if (comp.parameters >= 1) {
                                                def value1 = settings["condValue$id#1"]
                                                def device1 = settings["condDev$id#1"]
                                                def variable1 = settings["condVar$id#1"]
                                                if (!extraComparisons || ((device1 == null) && (variable1 == null))) {
                                                    input "condValue$id#1", attr.type, title: (comp.parameters == 1 ? "Value" : "From value"), options: attr.options, range: attr.range, required: true, multiple: comp.multiple, submitOnChange: true
                                                }
                                                if (extraComparisons) {
                                                    if ((value1 == null) && (variable1 == null)) {
                                                        input "condDev$id#1", "capability.${capability.name}", title: (device1 == null ? "... or choose a device to compare ..." : (comp.parameters == 1 ? "Device" : "From")), required: true, multiple: comp.multiple, submitOnChange: true
                                                    }
                                                    if ((value1 == null) && (device1 == null)) {
                                                        input "condVar$id#1", "enum", options: varList, title: (variable1 == null ? "... or choose a variable to compare ..." : (comp.parameters == 1 ? "Variable" : "From")), required: true, multiple: false, submitOnChange: true, capitalization: "none"
                                                    }
                                                    if (((variable1 != null) || (device1 != null)) && ((attr.type == "number") || (attr.type == "decimal"))) {
                                                        input "condOffset$id#1", attr.type, range: "*..*", title: "Offset (+/-" + (attr.unit ? " ${attr.unit})" : ")"), required: true, multiple: false, defaultValue: 0, submitOnChange: true
                                                    }
                                                }
                                            }
                                            if (comp.parameters == 2) {
                                                def value2 = settings["condValue$id#2"]
                                                def device2 = settings["condDev$id#2"]
                                                def variable2 = settings["condVar$id#2"]
                                                if (!extraComparisons || ((device2 == null) && (variable2 == null))) {
                                                    input "condValue$id#2", attr.type, title: "Through value", options: attr.options, range: attr.range, required: true, multiple: false, submitOnChange: true
                                                }
                                                if (extraComparisons) {
                                                    if ((value2 == null) && (variable2 == null)) {
                                                        input "condDev$id#2", "capability.${capability.name}", title: (device2 == null ? "... or choose a device to compare ..." : "Through device"), required: true, multiple: false, submitOnChange: true
                                                    }
                                                    if ((value2 == null) && (device2 == null)) {
                                                        input "condVar$id#2", "enum", options: varList, title: (variable2 == null ? "... or choose a variable to compare ..." : "Through variable"), required: true, multiple: false, submitOnChange: true, capitalization: "none"
                                                    }
                                                    if (((variable2 != null) || (device2 != null)) && ((attr.type == "number") || (attr.type == "decimal"))) {
                                                        input "condOffset$id#1", attr.type, range: "*..*", title: "Offset (+/-" + (attr.unit ? " ${attr.unit})" : ")"), required: true, multiple: false, defaultValue: 0, submitOnChange: true
                                                    }
                                                }
                                            }

                                            if (comp.timed) {
                                                input "condFor$id", "enum", title: "Time restriction", options: ["for at least", "for less than"], required: true, multiple: false, submitOnChange: true
                                                input "condTime$id", "enum", title: "Interval", options: timeOptions(), required: true, multiple: false, submitOnChange: true
                                            }
                                        }
                                    }
                                    //input "condDevice$id", "", title: title, required: true, multiple: false, submitOnChange: true
                                }
                            }
                        }
                    }
                }
			}
            
            if (showDateTimeRepeat) {
				section(title: "Repeat this trigger...") {
                    input "condRepeat$id", "enum", title: "Repeat", options: timeRepeatOptions(), required: true, multiple: false, defaultValue: "every day", submitOnChange: true
                    def repeat = settings["condRepeat$id"]
                    if (repeat) {
                        def incremental = repeat.contains("number")
                        if (incremental) {
                            //using a time offset
                            input "condRepeatEvery$id", "number", title: repeat.replace("every n", "N"), range: "1..*", required: true, multiple: false, defaultValue: 2, submitOnChange: true
                            recurring = true
                        }
                        def monthOfYear = null
                        if (repeat.contains("week")) {
							input "condRepeatDayOfWeek$id", "enum", title: "Day of the week", options: timeDayOfWeekOptions(), required: true, multiple: false, submitOnChange: true
                        }
                        if (repeat.contains("month") || repeat.contains("year")) {
                            //oh-oh, monthly
                            input "condRepeatDay$id", "enum", title: "On", options: timeDayOfMonthOptions(), required: true, multiple: false, submitOnChange: true
                            def dayOfMonth = settings["condRepeatDay$id"]
                            def certainDay = false
                            def dayOfWeek = null
                            if (dayOfMonth) {
                                if (dayOfMonth.contains("week")) {
                                    certainDay = true
                                    input "condRepeatDayOfWeek$id", "enum", title: "Day of the week", options: timeDayOfWeekOptions(), required: true, multiple: false, submitOnChange: true
                                    dayOfWeek = settings["condDOWOM$id"]
                                }
                            }
                            if (repeat.contains("year")) {// && (dayOfMonth) && (!certainDay || dayOfWeek)) {
                                //oh-oh, yearly
                                input "condRepeatMonth$id", "enum", title: "Of", options: timeMonthOfYearOptions(), required: true, multiple: false, submitOnChange: true
                                monthOfYear = settings["condRepeatMonth$id"]
                            }
                        }
                    }
                }
			}
            
            if (showDateTimeFilter) {
            	section(title: "Date & Time Filters", hideable: !state.config.expertMode, hidden: !(state.config.expertMode || settings["condMOH$id"] || settings["condHOD$id"] || settings["condDOW$id"] || settings["condDOM$id"] || settings["condMOY$id"] || settings["condY$id"])) {
                	paragraph "But only on these..."
					input "condMOH$id", "enum", title: "Minute of the hour", description: 'Any minute of the hour', options: timeMinuteOfHourOptions(), required: false, multiple: true, submitOnChange: true
					input "condHOD$id", "enum", title: "Hour of the day", description: 'Any hour of the day', options: timeHourOfDayOptions(), required: false, multiple: true, submitOnChange: true
					input "condDOW$id", "enum", title: "Day of the week", description: 'Any day of the week', options: timeDayOfWeekOptions(), required: false, multiple: true, submitOnChange: true
					input "condDOM$id", "enum", title: "Day of the month", description: 'Any day of the month', options: timeDayOfMonthOptions2(), required: false, multiple: true, submitOnChange: true
					input "condWOM$id", "enum", title: "Week of the month", description: 'Any week of the month', options: timeWeekOfMonthOptions(), required: false, multiple: true, submitOnChange: true
					input "condMOY$id", "enum", title: "Month of the year", description: 'Any month of the year', options: timeMonthOfYearOptions(), required: false, multiple: true, submitOnChange: true
					input "condY$id", "enum", title: "Year", description: 'Any year', options: timeYearOptions(), required: false, multiple: true, submitOnChange: true
                }
            }

			section(title: (condition.trg ? "Trigger" : "Condition") + " Overview") {
                paragraph getConditionDescription(id)
                if (condition.attr == "time") {
                	if (condition.trg) {
                		def value = ""
                        def nextTime = null
                        for (def i = 0; i < 5; i++) {
                       		nextTime = getNextTimeTrigger(condition, nextTime)
                            if (nextTime) {
                            	value = value + ( value ? "\n" : "") + formatLocalTime(nextTime)
                            } else {
                            	break
                            }
                        }
                    	paragraph value ? value : "(not happenning any time soon)", title: "Next scheduled trigger(s)", required: true, state: ( value ? "complete" : null )
                    } else {
                		def value = evaluateTimeCondition(condition)
                    	paragraph "Current evaluation: $value", required: true, state: ( value ? "complete" : null )
                    }
                }
	            href "pageActionGroup", params:[conditionId: id], title: "Individual actions", description: "Tap to set individual actions for this condition", state: complete, submitOnChange: true
			}

			section() {
				paragraph "NOTE: To delete this condition, simply remove all devices from the list above and tap Done"
            }
            
            section(title: "Advanced options", hideable: !state.config.expertMode, hidden: !state.config.expertMode) {
                input "condVarD$id", "string", title: "Save last evaluation date", description: "Enter a variable name to store the date in", required: false, capitalization: "none"
                input "condVarS$id", "string", title: "Save last evaluation state", description: "Enter a variable name to store the state in", required: false, capitalization: "none"
	            if (trigger) {
                	input "condVarT$id", "string", title: "Save event date on true", description: "Enter a variable name to store the date in", required: false, capitalization: "none"
                	input "condVarV$id", "string", title: "Save event value on true", description: "Enter a variable name to store the value in", required: false, capitalization: "none"
                	input "condVarF$id", "string", title: "Save event date on false", description: "Enter a variable name to store the date in", required: false, capitalization: "none"
                	input "condVarW$id", "string", title: "Save event value on false", description: "Enter a variable name to store the value in", required: false, capitalization: "none"
                }
            }
            
            section(title: "Required data - do not change", hideable: true, hidden: true) {            
                input "condParent$id", "number", title: "Parent ID", description: "Value needs to be $pid, do not change", range: "$pid..$pid", defaultValue: pid
			}
	    }
    }
}

def pageConditionVsTrigger() {
	state.run = "config"
	dynamicPage(name: "pageConditionVsTrigger", title: "Conditions versus Trigers", uninstall: false, install: false) {
    	section() {
			paragraph "All Pistons are event-driven. This means that an action is taken whenever something happens while the Piston is watching over. To do so, the Piston subscribes to events from all the devices you use while building your 'If...' and - in case of latching Pistons - your 'But if...' statements as well. Since a Piston subscribes to multiple device events, it is evaluated every time such an event occurs. Depending on your conditions, a device event may not necessarily make any change to the evaluated state of the Piston (think OR), but the Piston is evaluated either way, making it possible to execute actions even if the Piston's status didn't change. More about this under the 'Then...' or 'Else...' sections of the Piston." 
	        paragraph "Events tell Pistons something has changed. Depending on the logic you are trying to implement, sometimes you need to check that the state of a device is within a certain range, and sometimes you need to react to a device state reaching a certain value, list or range.\n\nLet's start with an example. Say you have a temperature sensor and you want to monitor its temperature. You want to be alerted if the temperature is over 100°F. Now, assume the temperature starts at 99°F and increases steadily at a rate of one degree Fahrenheit per minute.", title: "State vs. State Change"
            paragraph "If you use a condition, the Piston will be evaluated every one minute, as the temperature changes. The first evaluation will result in a false condition as the temperature reaches 100°F. Remember, our condition is for the temperature to be OVER 100°F. The next minute, your temperature is reported at 101°F which will cause the Piston to evaluate true this time. Your 'Then...' actions will now have a chance at execution. The next minute, as the temperature reaches 102°F, the Piston will again evaluate true and proceed to executing your 'Then...' actions. This will happen for as long as the temperature remains over 100°F and will possibly execute your actions every time a new temperature is read that matches that condition. You could use this to pass the information along to another service (think IFTTT) or display it on some sort of screen. But not for turning on a thermostat - you don't neet to turn the thermostat on every one minute, it's very likely already on from your last execution.", title: "Using a Condition"
            paragraph "If you use a trigger, the Piston will now be on the lookout for a certain state change that 'triggers' our evaluation to become true. You will no longer look for a temperature over 100°F, but instead you will be looking for when the temperature exceeds 100°F. This means your actions will only be executed when the temperature actually transitioned from below or equal to 100°F to over 100°F. This means your actions will only execute once and for the Piston to fire your actions again, the temperature would have to first drop at or below 100°F and then raise again to exceed your set threshold of 100°F. Now, this you could use to control a thermostat, right?", title: "Using a Trigger"
		}
    }
}

def pageVariables() {
	state.run = "config"
	dynamicPage(name: "pageVariables", title: "", install: false, uninstall: false) {
    	section("Local Variables") {
        	def cnt = 0
            for (def variable in state.store.sort{ it.key }) {
            	def value = getVariable(variable.key)
                if ((value instanceof Long) && (value > 999999999999)) {
                	value = formatLocalTime(value)
                }
                paragraph "$value", title: "${variable.key}"
                cnt++
            }
            if (!cnt) {
            	paragraph "No local variables yet"
            }
        }
    	section("System Variables") {
            for (def variable in state.systemStore.sort{ it.key }) {
            	def value = getVariable(variable.key)
                if ((value instanceof Long) && (value > 999999999999)) {
                	value = formatLocalTime(value)
                }
                paragraph "$value", title: "${variable.key}"
            }
        }
	}
}

def pageActionGroup(params) {
	state.run = "config"
	def conditionId = params?.conditionId != null ? params?.conditionId : state.config.conditionId
    state.config.conditionId = conditionId
	def value = true
    def block = "IF"
    if (conditionId < 0) {
    	switch (settings.mode) {
        	case "Simple":
            	value = false
                break
        	case "Else-If":
            	block = "ELSE IF"
                break
			case "Latching":
            	block = "BUT IF"
                break
        }
    }
	dynamicPage(name: "pageActionGroup", title: "$block ... THEN ..", uninstall: false, install: false) {
    	section() {
        	paragraph "Add actions below to be executed once, whenever the evaluation of your $block condition(s) changes to '$value'", title: "Do..."
            def actions = listActions(conditionId, false)
            for(action in actions) {
            	href "pageAction", params:[actionId: action.id], title: "Action #${action.id}", description: "Action description goes here", required: true, state: "complete", submitOnChange: true
            }
            href "pageAction", params:[command: "add", conditionId: conditionId, branch: "do"], title: "Add an action", description: "Actions allow control of various devices in your ecosystem", state: (actions.size() ? null : "complete"), submitOnChange: true
        }
    	section() {
        	paragraph "Add actions below to be executed every time the evaluation of your condition(s) is '$value'", title: "Do While..."
            def actions = listActions(conditionId, true)
            if (!actions.size()) {
                paragraph "CAUTION: Only use this section if you know what you are doing. Because evaluations may happen whenever various attributes of various devices involved in your condition(s) change, actions in this list may be executed very often and may therefore yield unexpected results\n\nYE BE WARNED!", required: true, state: null
			}
            for(action in actions) {
            	paragraph "action goes here"
            }
            href "pageAction", params:[command: "add", conditionId: conditionId, branch: "doWhile"], title: "Add an action", description: "Actions allow control of various devices in your ecosystem", required: true, state: "complete", submitOnChange: true
        }
        
    }
}

def pageAction(params) {
	state.run = "config"
   	//this page has a dual purpose, either action wizard or task manager
    //if no devices have been previously selected, the page acts as a wizard, guiding the use through the selection of devices
    //if at least one device has been previously selected, the page will guide the user through setting up tasks for selected devices
    def action = null
    if (params?.command == "add") {
        action = createAction(params?.conditionId, params?.branch == "doWhile")
    } else {   	
		action = getAction(params?.actionId ? params?.actionId : state.config.actionId)
    }
    if (action) {
    	updateAction(action)
    	def id = action.id
        state.config.actionId = id
        def pid = action.pid
    
        dynamicPage(name: "pageAction", title: "Action #$id", uninstall: false, install: false) {
            def devices = []
            def usedCapabilities = []
            //did we get any devices? search all capabilities
            for(def capability in capabilities()) {
                if (capability.devices) {
                    //only if the capability published any devices - it wouldn't be here otherwise
                    def dev = settings["actDev$id#${capability.name}"]
                    if (dev && dev.size()) {
                        devices = devices + dev
                        //add to used capabilities - needed later
                        if (!(capability.name in usedCapabilities)) {
                            usedCapabilities.push(capability.name)
                        }
                    }
                }
            }
            if (devices.size() == 0) {
            	//category selection page
                for(def category in listCommandCategories()) {
                    section(title: category) {
                        def options = []
                        for(def command in listCategoryCommands(category)) {
                            def option = getCommandGroupName(command)
                            if (option && !(option in options)) {
                                options.push option
                                href "pageActionDevices", params:[actionId: id, command: command], title: option
                            }
                        }
                    }
                }
            } else {
            	//actual action page
                section() {
                    def names=[]
                    for(device in devices) {
                        if (!(device.label in names)) {
                            names.push(device.label)
                        }
                    }
                    href "pageActionDevices", title: "With...", description: "${buildNameList(names, "and")}", state: "complete"
                }
                def prefix = "actTask$id#"
                def tasks = settings.findAll{it.key.startsWith(prefix)}
                def maxId = 1
                def ids = []
                //we need to get a list of all existing ids that are used
                for (task in tasks) {
                    if (task.value) {
                        def tid = task.key.replace(prefix, "")
                        if (tid.isInteger()) {
                            tid = tid.toInteger()
                            maxId = tid >= maxId ? tid + 1 : maxId
                            ids.push(tid)
                        }
                    }
                }
                //sort the ids, we really want to have these in the proper order
                ids = ids.sort()
                def availableCommands = listCommonDeviceCommands(devices, usedCapabilities)
                for (vcmd in virtualCommands()) {
                    if (!vcmd.requires || !(vcmd.display in availableCommands)) {
                        //single device support - some virtual commands require only one device, can't handle more at a time
                        if (!vcmd.singleDevice || (devices.size() == 1)) {
                            availableCommands.push(virtualCommandPrefix() + vcmd.display)
                        }
                    }
                }
                def idx = 0
                for (tid in ids) {
                    //display each 
                    section(title: idx == 0 ? "Task list" : "") {
                        input "$prefix$tid", "enum", options: availableCommands, title: (idx == 0 ? "" : "And then"), required: true, state: "complete", submitOnChange: true
                        //parameters
                        def cmd = settings["$prefix$tid"]
                        def virtual = (cmd && cmd.startsWith(virtualCommandPrefix()))
                        def custom = (cmd && cmd.startsWith(customCommandPrefix()))
                        cmd = cleanUpCommand(cmd)
                        def command = null
                        if (virtual) {
                            //dealing with a virtual command
                            command = getVirtualCommandByDisplay(cmd)
                        } else {
                            command = getCommandByDisplay(cmd)
                        }
                        if (command) {
                            if (command.parameters) {
                                def i = 0
                                for (def parameter in command.parameters) {
                                    def param = parseCommandParameter(parameter)
                                    if (param) {
                                        if (param.type == "attribute") {
                                            input "actParam$id#$tid-$i", "devices", options: listCommonDeviceAttributes(devices), title: param.title, required: param.required, submitOnChange: param.last, multiple: false
                                        } else if (param.type == "attributes") {
                                            input "actParam$id#$tid-$i", "devices", options: listCommonDeviceAttributes(devices), title: param.title, required: param.required, submitOnChange: param.last, multiple: true
                                        } else if (param.type == "variable") {
                                            input "actParam$id#$tid-$i", "enum", options: listVariables(true), title: param.title, required: param.required, submitOnChange: param.last, multiple: false
                                        } else if (param.type == "variables") {
                                            input "actParam$id#$tid-$i", "enum", options:  listVariables(true), title: param.title, required: param.required, submitOnChange: param.last, multiple: true
                                        } else {
                                            input "actParam$id#$tid-$i", param.type, range: param.range, options: param.options, title: param.title, required: param.required, submitOnChange: param.last || (i == command.varEntry), capitalization: "none"
                                        }
                                        if (param.last && settings["actParam$id#$tid-$i"]) {
                                            //this is the last parameter, if filled in
                                            break
                                        }
                                    } else {
                                        paragraph "Invalid parameter definition for $parameter"
                                    }
                                    i++
                                }
                            }
                        }
                    }
                    idx++
                }
                section() {
                    input "$prefix$maxId", "enum", options: availableCommands, title: "Add a task", required: !ids.size(), submitOnChange: true
                }
                
                if (id) {
                    section(title: "Required data - do not change", hideable: true, hidden: true) {            
                        input "actParent$id", "number", title: "Parent ID", description: "Value needs to be $pid, do not change", range: "$pid..$pid", defaultValue: pid
                    }
                }
                
            }
        }
    }
}

def pageActionDevices(params) {
	state.run = "config"
    def actionId = params?.actionId
	def command = params?.command
    command = command ? command : state.selectedCommand
    state.selectedCommand = command
    
	dynamicPage(name: "pageActionDevices", title: "", uninstall: false, install: false) {
	    def capabilities = listCommandCapabilities(command)
        if (capabilities) {
        	def caps = [:]
           	//we got a list of capabilities to display
            for(def capability in capabilities) {
            	//go through each and look for "devices" - the user-friendly name of what kind of devices the capability stands for
            	if (capability.devices) {
            		def cap = caps[capability.name] ? caps[capability.name] : []
                	cap.push(capability.devices)
                    caps[capability.name] = cap
                }
            }
            if (caps.size()) {
            	for(cap in caps) {
                	section() {
	                    input "actDev$actionId#${cap.key}", "capability.${cap.key}", title: "Select ${buildNameList(cap.value, "or")}", multiple: true, required: false
	                }
                }
            }
        }
    }
}

private buildIfContent() {
	buildIfContent(state.config.app.conditions.id, 0)
}

private buildIfOtherContent() {
	buildIfContent(state.config.app.otherConditions.id, 0)
}

private buildIfContent(id, level) {
	def condition = getCondition(id)
    if (!condition) {
    	return null
    }
    def conditionGroup = (condition.children != null)
    def conditionType = (condition.trg ? "trigger" : "condition")
    level = (level ? level : 0)
    def pre = ""
    def preNot = ""
    def tab = ""
    def aft = ""
    switch (level) {
    	case 1:
        	pre = " ┌ ("
        	preNot = " ┌ NOT ("
        	tab = " │   "
        	aft = " └ )"
	        break;
        case 2:
    	    pre = " │ ┌ ["
    	    preNot = " │ ┌ NOT ["
        	tab = " │ │   "
       		aft = " │ └ ]"
        	break;
        case 3:
	        pre = " │ │ ┌ <"
	        preNot = " │ │ ┌ NOT {"
        	tab = " │ │ │   "
    	    aft = " │ │ └ >"
        	break;
    }
	if (!conditionGroup) {
		href "pageCondition", /*image: "https://raw.githubusercontent.com/ady624/SmartThingers/master/resources/images/${conditionType}.png",*/ params: ["conditionId": id], title: "", description: tab + getConditionDescription(id).trim(), state: "complete", required: false, submitOnChange: false
    } else {
    
        def grouping = settings["condGrouping$id"]
        def negate = settings["condNegate$id"]
    
    	if (pre) {
			href "pageConditionGroupL${level}", /*image: "https://raw.githubusercontent.com/ady624/SmartThingers/master/resources/images/folder.png",*/ params: ["conditionId": id], title: "", description: (negate? preNot : pre), state: "complete", required: true, submitOnChange: false
        }
        
        def cnt = 0
        for (child in condition.children) {
        	buildIfContent(child.id, level + (child.children == null ? 0 : 1))
            cnt++            
            if (cnt < condition.children.size()) {
            	def page = (level ? "pageConditionGroupL${level}" : (id == 0 ? "pageIf" : "pageIfOther"))
            	href page, /*image: "https://raw.githubusercontent.com/ady624/SmartThingers/master/resources/images/" + (level ? "folder.png" : "blank.png"),*/ params: ["conditionId": id], title: "", description: tab + grouping, state: "complete", required: true, submitOnChange: false
            }
        }
        
        if (aft) {
			href "pageConditionGroupL${level}", /*image: "https://raw.githubusercontent.com/ady624/SmartThingers/master/resources/images/folder.png",*/ params: ["conditionId": id], title: "", description: aft, state: "complete", required: true, submitOnChange: false
        }
    }
}


/********** COMMON INITIALIZATION METHODS **********/
def installed() {
	initialize()
}

def updated() {
	unsubscribe()
	initialize()
}

def initialize() {
	if (parent) {
    	initializeCoREPiston()
    } else {
    	initializeCoRE()
    }
}



/******************************************************************************/
/*** 																		***/
/*** COMMON PUBLISHED METHODS												***/
/*** 																		***/
/******************************************************************************/

def mem(showBytes = true) {
	def bytes = state.toString().length()
	return Math.round(100.00 * (bytes/ 100000.00)) + "%${showBytes ? " ($bytes bytes)" : ""}"
}

def cpu() {
    if (state.lastExecutionTime == null) {
    	return "N/A"
    } else {
    	def cpu = Math.round(state.lastExecutionTime / 20000)
        if (cpu > 100) {
        	cpu = 100
        }
        return "$cpu%"
    }
}

def getVariable(name) {
    name = sanitizeVariableName(name)
    if (name == "\$now") return now()
    if (name == "\$currentStateDuration") {
    	try {
        	return state.systemStore["\$currentStateSince"] ? now() - (new Date(state.systemStore["\$currentStateSince"])).time : null
        } catch(all) {
        	return null
        }
    }
	if (!name) {
    	return null
    }
    if (parent && name.startsWith("@")) {
    	return parent.getVariable(name)
    } else {
    	if (name.startsWith("\$")) {
			return state.systemStore[name]
        } else {
			return state.store[name]
    	}
    }
}

def setVariable(name, value, system = false) {
    name = sanitizeVariableName(name)
    if (name == "\$now") value = null
    if (name == "\$currentStateDuration") value = null
	if (!name) {
    	return
    }
    if (parent && name.startsWith("@")) {
    	parent.setVariable(name, value)
    } else {
    	if (name.startsWith("\$")) {
        	if (system) {
				state.systemStore[name] = value
            }
        } else {
	    	debug "Storing variable $name with value $value"
			state.store[name] = value
    	}
    }
    //TODO: date&time triggers based on variables being changed need to be reevaluated
}

def listVariables(config = false) {
	def result = []
    def parentResult = null
    def systemResult = []
    for (variable in state.store) {
    	result.push(variable.key)
    }
    for (variable in state.systemStore) {
    	result.push(variable.key)
    }
    if (parent) {
    	parentResult = parent.listVariables()
    }
    if (parent && config) {
    	//look for variables set during conditions
        def list = settings.findAll{it.key.startsWith("condVar") && !it.key.contains("#")}
        for (it in list) {
        	def var = it.value
            if (var) {
            	if (var.startsWith("@")) {
                	//global
                    if (!(var in parentResult)) {
                    	parentResult.push(var)
                    }
                } else {
                	//local
                    if (!(var in result)) {
                    	result.push(var)
                    }
                }
            }
        }
        //look for tasks that set variables...
        list = settings.findAll{it.key.startsWith("actTask")}
        for (it in list) {
        	if (it.value) {
            	def virtualCommand = getVirtualCommandByDisplay(cleanUpCommand(it.value))
                if (virtualCommand && (virtualCommand.varEntry != null)) {
                	def var = settings[it.key.replace("actTask", "actParam") + "-${virtualCommand.varEntry}"]
                    if (var) {
                        if (var.startsWith("@")) {
                            //global
                            if (!(var in parentResult)) {
                                parentResult.push(var)
                            }
                        } else {
                            //local
                            if (!(var in result)) {
                                result.push(var)
                            }
                        }
                    }
				}
            }
        }
    }
    return result.sort() + (parentResult ? parentResult.sort() : []) + systemResult.sort()
}













/******************************************************************************/
/***																		***/
/*** CoRE CODE																***/
/***																		***/
/******************************************************************************/


/******************************************************************************/
/*** CoRE INITIALIZATION METHODS											***/
/******************************************************************************/

def initializeCoRE() {
    state.store = state.store ? state.store : [:]
    state.systemStore = state.systemStore ? state.systemStore : [:]
}

def childUninstalled() {}

/******************************************************************************/
/*** CoRE PUBLISHED METHODS													***/
/******************************************************************************/

def expertMode() {
	return !!settings["expertMode"]
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
        atomicState.charts = charts
        state.charts = charts
    }
   	return null
}

def generatePistonName() {
	if (parent) {
    	return null
    }
    def apps = getChildApps()
	def i = 1
    while (true) {
    	def name = i == 5 ? "Mambo No. 5" : "CoRE Piston #$i"
        for (app in apps) {
        	if (app.label == name) {
            	i++
            	continue
            }
        }
        return name
    }
}








/******************************************************************************/
/***																		***/
/*** CoRE PISTON CODE														***/
/***																		***/
/******************************************************************************/


/******************************************************************************/
/*** CoRE PISTON INITIALIZATION METHODS										***/
/******************************************************************************/

def initializeCoREPiston() {
	debug "", 0
	debug "Initializing app...", 1
	// TODO: subscribe to attributes, devices, locations, etc.
    //move app to production
    state.app = state.config ? state.config.app : state.app
    //save misc
    state.app.mode = settings.mode
    
	state.run = "app"
    
    state.cache = [:]
    state.tasks = state.tasks ? state.tasks : [:]
    state.store = state.store ? state.store : [:]
    state.systemStore = state.systemStore ? state.systemStore : [:]
    
    subscribeToAll(state.app)
  
    subscribe(app, appHandler)
    
    state.remove("config")
    //uncomment next line to clear system store
    //state.systemStore = [:]
    setVariable("\$lastInitialized", now(), true)
    setVariable("\$now", null, true)
    setVariable("\$currentStateDuration", null, true)
    setVariable("\$currentState", state.currentState, true)
    setVariable("\$currentStateSince", state.currentStateSince, true)
    processTasks()
	debug "Done", -1

	//we need to finalize to write atomic state
	//save all atomic states to state
    //to avoid race conditions
	//state.cache = atomicState.cache
    //state.tasks = atomicState.tasks
}

/* prepare configuration version of app */
private configApp() {
	//TODO: rebuild (object-oriented) app object from settings
	if (!state.config) {
    	//initiate config app, since we have no running version yet (not yet installed)
        state.config = [:]
        state.config.conditionId = 0
    	state.config.app = state.app ? state.app : null
        if (!state.config.app) {
        	state.config.app = [:]
            //create the root condition
            state.config.app.conditions = createCondition(true)
            state.config.app.conditions.id = 0
            state.config.app.otherConditions = createCondition(true)
            state.config.app.otherConditions.id = -1
            state.config.app.actions = []
		    //get expert savvy
			state.config.expertMode = parent.expertMode()
        }
    }

}
private subscribeToAll(app) {
	debug "Initializing subscriptions...", 1
	//we have to maintain two separate logic threads for the latching mode
    //to do so, we first simulate
    state.deviceSubscriptions = 0
	def hasTriggers = getConditionHasTriggers(app.conditions)
   	def hasLatchingTriggers = false
    
   	if (settings.mode == "Latching") {
    	//we really get the count
    	hasLatchingTriggers = getConditionHasTriggers(app.otherConditions)
		//simulate subscribing to both lists
		def subscriptions = subscribeToDevices(app.conditions, hasTriggers, null, null, null, null)
		def latchingSubscriptions = subscribeToDevices(app.otherConditions, hasLatchingTriggers, null, null, null, null)
        //we now have the two lists that we'd be subscribing to, let's figure out the common elements
        def commonSubscriptions = [:]
        for (subscription in subscriptions) {
        	if (latchingSubscriptions.containsKey(subscription.key)) {
            	//found a common subscription, save it
                commonSubscriptions[subscription.key] = true
            }
        }
        //perform subscriptions
		subscribeToDevices(app.conditions, false, bothDeviceHandler, null, commonSubscriptions, null)
		subscribeToDevices(app.conditions, hasTriggers, deviceHandler, null, null, commonSubscriptions)
		subscribeToDevices(app.otherConditions, hasLatchingTriggers, latchingDeviceHandler, null, null, commonSubscriptions)       
    } else {
    	//simple IF case, no worries here
    	subscribeToDevices(app.conditions, hasTriggers, deviceHandler, null, null, null)
    }
	debug "Finished subscribing", -1
}

private subscribeToDevices(condition, triggersOnly, handler, subscriptions, onlySubscriptions, excludeSubscriptions) {
	if (subscriptions == null) {
    	subscriptions = [:]
    }
	def result = 0
    if (condition) {
        if (condition.children != null) {
            //we're dealing with a group
            for (child in condition.children) {
                subscribeToDevices(child, triggersOnly, handler, subscriptions, onlySubscriptions, excludeSubscriptions)
            }
        } else {
        	if (condition.trg || !triggersOnly) {
            	//get the details
                def capability = getCapabilityByDisplay(condition.cap)
            	def devices = capability.virtualDevice ? (capability.attribute == "time" ? [] : [capability.virtualDevice]) : settings["condDevices${condition.id}"]
                def attribute = capability.virtualDevice ? capability.attribute : condition.attr
                if (devices) {
                	for (device in devices) {
                    	def subscription = "${device.id}-${attribute}"
                        if ((excludeSubscriptions == null) || !(excludeSubscriptions[subscription])) {
                        	//if we're provided with an exclusion list, we don't subscribe to those devices/attributes events
                            if ((onlySubscriptions == null) || onlySubscriptions[subscription]) {
                            	//if we're provided with a restriction list, we use it
                                if (!subscriptions[subscription]) {
                                    subscriptions[subscription] = true //[deviceId: device.id, attribute: attribute]
                                    if (handler) {
	                                    //we only subscribe to the device if we're provided a handler (not simulating)
                                        debug "Subscribing to events from $device for attribute $attribute, handler is $handler"
                                        subscribe(device, attribute, handler)
                                        state.deviceSubscriptions = state.deviceSubscriptions ? state.deviceSubscriptions + 1 : 1
                                        //initialize the cache for the device - this will allow the triggers to work properly on first firing
                                        state.cache[device.id + "-" + attribute] = [v: device.currentValue(attribute), t: now()]
                                        
                                    }
                                }
                            }
						}
                    }
                } else {
                	return
                }
            }
        }
    }
    return subscriptions
}













/******************************************************************************/
/*** CoRE PISTON CONFIGURATION METHODS										***/
/******************************************************************************/

//creates a condition (grouped or not)
private createCondition(group) {
    def condition = [:]
    //give the new condition an id
    condition.id = getNextConditionId()
    //initiate the condition type
    if (group) {
    	//initiate children
        condition.children = []
        condition.actions = []
    } else {
    	condition.type = null
    }
    return condition
}

//creates a condition and adds it to a parent
private createCondition(parentConditionId, group) {	
    def parent = getCondition(parentConditionId)
    if (parent) {
		def condition = createCondition(group)
    	//preserve the parentId so we can rebuild the app from settings
    	condition.parentId = parent ? parent.id : null
        //calculate depth for new condition
        condition.level = (parent.level ? parent.level : 0) + 1
   		//add the new condition to its parent, if any
        //set the parent for upwards traversal
   		parent.children.push(condition)
    	//return the newly created condition
    	return condition
	}
    return null
}

//deletes a condition
private deleteCondition(conditionId) {
	def condition = getCondition(conditionId)
    if (condition) {
    	def parent = getCondition(condition.parentId)
        if (parent) {
			parent.children.remove(condition);
        }
    }
}

private updateCondition(condition) {
	condition.cap = settings["condCap${condition.id}"]
	condition.dev = []
    condition.attr = cleanUpAttribute(settings["condAttr${condition.id}"])
    if (!condition.attr) {
	    def cap = getCapabilityByDisplay(condition.cap)
        if (cap && cap.attribute) {
    		condition.attr = cap.attribute
        }
    }
    if (condition.attr == "time") {
    	condition.dev.push(condition.attr)
    } else {
        for (device in settings["condDevices${condition.id}"])
        {
            //save the list of device IDs - we can't have the actual device objects in the state
            condition.dev.push(device.id)
        }
    }
    condition.comp = cleanUpComparison(settings["condComp${condition.id}"])
    condition.trg = !!isComparisonOptionTrigger(condition.attr, condition.comp)
	condition.mode = condition.trg ? "Any" : (settings["condMode${condition.id}"] ? settings["condMode${condition.id}"] : "Any")
    condition.val1 = settings["condValue${condition.id}#1"]
    condition.dev1 = settings["condDev${condition.id}#1"] ? settings["condDev${condition.id}#1"].label : null
    condition.var1 = settings["condVar${condition.id}#1"]
    condition.val2 = settings["condValue${condition.id}#2"]
    condition.dev2 = settings["condDev${condition.id}#2"] ? settings["condDev${condition.id}#2"].label : null
    condition.var2 = settings["condVar${condition.id}#2"]
    condition.for = settings["condFor${condition.id}"]
    condition.fort = settings["condTime${condition.id}"]
    condition.t1 = settings["condTime${condition.id}#1"]
    condition.t2 = settings["condTime${condition.id}#2"]
    condition.o1 = settings["condOffset${condition.id}#1"]
    condition.o2 = settings["condOffset${condition.id}#2"]
    condition.e = settings["condEvery${condition.id}"]
    condition.e = condition.e ? condition.e : 5
    condition.m = settings["condMinute${condition.id}"]
    
	//time repeat
    condition.r = settings["condRepeat${condition.id}"]
    condition.re = settings["condRepeatEvery${condition.id}"]
    condition.re = condition.re ? condition.re : 2
    condition.rd = settings["condRepeatDay${condition.id}"]
    condition.rdw = settings["condRepeatDayOfWeek${condition.id}"]
    condition.rm = settings["condRepeatMonth${condition.id}"]
    
    //time filters
    condition.fmh = settings["condMOH${condition.id}"]
    condition.fhd = settings["condHOD${condition.id}"]
    condition.fdw = settings["condDOW${condition.id}"]
    condition.fdm = settings["condDOM${condition.id}"]
    condition.fwm = settings["condWOM${condition.id}"]
    condition.fmy = settings["condMOY${condition.id}"]
    condition.fy = settings["condY${condition.id}"]

	condition.grp = settings["condGrouping${condition.id}"]
    condition.grp = condition.grp && condition.grp.size() ? condition.grp : "AND"
    condition.not = !!settings["condNegate${condition.id}"]
    
    //variables
    condition.vd = settings["condVarD${condition.id}"]
    condition.vs = settings["condVarS${condition.id}"]
    condition.vt = settings["condVarT${condition.id}"]
    condition.vv = settings["condVarV${condition.id}"]
    condition.vf = settings["condVarF${condition.id}"]
    condition.vw = settings["condVarW${condition.id}"]
    
    condition = cleanUpMap(condition)
    return null
}

//used to get the next id for a condition, action, etc - looks into settings to make sure we're not reusing a previously used id
private getNextConditionId() {
	def nextId = getLastConditionId(state.config.app.conditions) + 1
	def otherNextId = getLastConditionId(state.config.app.otherConditions) + 1
    nextId = nextId > otherNextId ? nextId : otherNextId
    while (settings.findAll { it.key == "condParent" + nextId }) {
    	nextId++
    }
    return nextId
}

//helper function for getNextId
private getLastConditionId(parent) {
	if (!parent) {
    	return -1
    }
	def lastId = parent?.id    
    for (child in parent.children) {
        def childLastId = getLastConditionId(child)
        lastId = lastId > childLastId ? lastId : childLastId
    }
    return lastId
}


//creates a condition (grouped or not)
private createAction(parentId, doWhile) {
    def action = [:]
    //give the new condition an id
    action.id = getNextActionId()
    action.pid = parentId
    action.w = !!doWhile
    state.config.app.actions.push(action)
    return action
}

private getNextActionId() {
	def nextId = 1
    for(action in state.config.app.actions) {
    	if (action.id > nextId) {
        	nextId = action.id + 1
        }
    }
    while (settings.findAll { it.key == "actParent" + nextId }) {
    	nextId++
    }
    return nextId
}

private updateAction(action) {
//blah blah
}


















/******************************************************************************/
/*** ENTRY AND EXIT POINT HANDLERS											***/
/******************************************************************************/

def appHandler() {
}

def deviceHandler(evt) {
	entryPoint()
	//executes whenever a device in the primary if block has an event
	//starting primary IF block evaluation
    def perf = now()
    debug "", 0
	debug "Received a primary block device event", 1
    broadcastEvent(evt, true, false)
    //process tasks
    processTasks()
    perf = now() - perf
    debug "Done in ${perf}ms", -1
    exitPoint(perf)
}

def latchingDeviceHandler(evt) {
	entryPoint()
    
	//executes whenever a device in the primary if block has an event
	//starting primary IF block evaluation
    def perf = now()
    debug "", 0
	debug "Received a secondary block device event", 1
    broadcastEvent(evt, false, true)
    //process tasks
    processTasks()
    perf = now() - perf
    debug "Done in ${perf}ms", -1
    exitPoint(perf)
}

def bothDeviceHandler(evt) {
	entryPoint()
    
	//executes whenever a common use device has an event
	//broadcast to both IF blocks
    def perf = now()
    debug "", 0
	debug "Received a dual block device event", 1
    broadcastEvent(evt, true, true)
    //process tasks
    processTasks()
    perf = now() - perf
    debug "Done in ${perf}ms", -1
    exitPoint(perf)
}

def timeHandler() {
	entryPoint()
	//executes whenever a device in the primary if block has an event
	//starting primary IF block evaluation
    def perf = now()
    debug "", 0
    debug "Received a time event", 1
    processTasks()
    perf = now() - perf
    debug "Done in ${perf}ms", -1
    exitPoint(perf)
}

def recoveryHandler() {
	entryPoint()
	//executes whenever a device in the primary if block has an event
	//starting primary IF block evaluation
    def perf = now()
    debug "", 0
    debug "CAUTION: Received a recovery event", 1
    processTasks()
    perf = now() - perf
    debug "Done in ${perf}ms", -1
    exitPoint(perf)
}
private entryPoint() {
	//initialize whenever app runs
    //use the "app" version throughout
    state.run = "app"
	state.tasker = state.tasker ? state.tasker : []
}

private exitPoint(milliseconds) {
	def runStats = atomicState.runStats
	if (runStats == null) {
    	runStats = [:]
    }
    runStats.executionSince = runStats.executionSince ? runStats.executionSince : now()
    runStats.executionCount = runStats.executionCount ? runStats.executionCount + 1 : 1
    runStats.executionTime = runStats.executionTime ? runStats.executionTime + milliseconds : milliseconds
    runStats.minExecutionTime = runStats.minExecutionTime && runStats.minExecutionTime < milliseconds ? runStats.minExecutionTime : milliseconds
    runStats.maxExecutionTime = runStats.maxExecutionTime && runStats.maxExecutionTime > milliseconds ? runStats.maxExecutionTime : milliseconds
    runStats.lastExecutionTime = milliseconds
    
    def lastEvent = state.lastEvent
    if (lastEvent && lastEvent.delay) {
        runStats.eventDelay = runStats.eventDelay ? runStats.eventDelay + lastEvent.delay : lastEvent.delay
        runStats.minEventDelay = runStats.minEventDelay && runStats.minEventDelay < lastEvent.delay ? runStats.minEventDelay : lastEvent.delay
        runStats.maxEventDelay = runStats.maxEventDelay && runStats.maxEventDelay > lastEvent.delay ? runStats.maxEventDelay : lastEvent.delay
        runStats.lastEventDelay = lastEvent.delay
    }
    setVariable("\$previousEventExecutionTime", milliseconds, true)
    state.lastExecutionTime = milliseconds
	parent.updateChart("exec", milliseconds)
    atomicState.runStats = runStats
   


	//save all atomic states to state
    //to avoid race conditions
	state.cache = atomicState.cache
    state.tasks = atomicState.tasks
    state.runStats = atomicState.runStats    
}











/******************************************************************************/
/*** EVENT MANAGEMENT FUNCTIONS												***/
/******************************************************************************/

private broadcastEvent(evt, primary, secondary) {
	state.run = "app"
	//filter duplicate events and broadcast event to proper IF blocks
    def perf = now()
    def delay = perf - evt.date.getTime()
	debug "Processing event ${evt.name}${evt.device ? " for device ${evt.device}" : ""}${evt.deviceId ? " with id ${evt.deviceId}" : ""}${evt.value ? ", value ${evt.value}" : ""}, generated on ${evt.date}, about ${delay}ms ago", 1
    //save previous event
	setVariable("\$previousEventReceived", getVariable("\$currentEventReceived"), true)
    setVariable("\$previousEventDevice", getVariable("\$currentEventDevice"), true)
    setVariable("\$previousEventAttribute", getVariable("\$currentEventAttribute"), true)
    setVariable("\$previousEventValue", getVariable("\$currentEventValue"), true)
    setVariable("\$previousEventDate", getVariable("\$currentEventDate"), true)
    setVariable("\$previousEventDelay", getVariable("\$currentEventDelay"), true)        
    def lastEvent = [
    	event: [
        	device: evt.device ? "${evt.device}" : evt.deviceId,
            name: evt.name,
            value: evt.value,
            date: evt.date
        ],
        delay: delay
    ]
    state.lastEvent = lastEvent    
    setVariable("\$currentEventReceived", perf, true)
    setVariable("\$currentEventDevice", lastEvent.event.device, true)
    setVariable("\$currentEventAttribute", lastEvent.event.name, true)
    setVariable("\$currentEventValue", lastEvent.event.value, true)
    setVariable("\$currentEventDate", lastEvent.event.date && lastEvent.event.date instanceof Date ? lastEvent.event.date.time : null, true)
    setVariable("\$currentEventDelay", lastEvent.delay, true)    
    try {
	    parent.updateChart("delay", delay)
    } catch(all) {
    	debug "ERROR: Could not update delay chart", null, "error"
    }
    if (!evt.deviceId == "time") {
    	def cache = atomicState.cache
        cache = cache ? cache : [:]
    	def cachedValue = cache[evt.deviceId + '-' + evt.name]
    	def eventTime = evt.date.getTime()
		cache[evt.deviceId + '-' + evt.name] = [o: cachedValue ? cachedValue.v : null, v: evt.value, t: eventTime ]
    	atomicState.cache = cache
        state.cache = cache
		if (cachedValue) {
	    	if ((cachedValue.v == evt.value) && ((cachedValue.v instanceof String) || (eventTime < cachedValue.t) || (cachedValue.t + 2000 > eventTime))) {
	        	//duplicate event
	    		debug "WARNING: Received duplicate event for device ${evt.device}, attribute ${evt.name}='${evt.value}', ignoring...", null, "warn"
	            evt = null
	        }
	    }
	}
	try {
        if (evt) {    
            //broadcast to primary IF block
            def result1 = null
            def result2 = null
            if (primary) {
                result1 = evaluateConditionSet(evt, true)
                state.lastPrimaryEvaluationResult = result1
                state.lastPrimaryEvaluationDate = now()
                debug "Primary IF block evaluation result is $result1"
            }
            //broadcast to secondary IF block
            if (secondary) {
                result2 = evaluateConditionSet(evt, false)
                state.lastSecondaryEvaluationResult = result2
                state.lastSecondaryEvaluationDate = now()
                debug "Secondary IF block evaluation result is $result1"
            }
            def currentState = state.currentState
            def currentStateSince = state.currentStateSince
            def mode = state.app.mode

            switch (mode) {
                case "Latching":
                    if (currentState in [null, false]) {
                        if (result1) {
                            //flip on
                            state.currentState = true
                            state.currentStateSince = now()
                            debug "♦♦♦ Latching Piston changed state to true ♦♦♦"
                        }
                    }
                    if (crrentState in [null, true]) {
                        if (result2) {
                            //flip off
                            state.currentState = false
                            state.currentStateSince = now()
                            debug "♦♦♦♦ Latching Piston changed state to false ♦♦♦"
                        }
                    }
                    break
                case "Simple":
                    if (currentState != result1) {
                        state.currentState = result1
                        state.currentStateSince = now()
                        debug "♦♦♦♦ Simple Piston changed state to $result1 ♦♦♦"
                    }
                    break
                case "Else-If":
                    if (currentState != result1) {
                        state.currentState = result1
                        state.currentStateSince = now()
                        debug "♦♦♦ Else-If Piston changed state to $result1 ♦♦♦"
                    }
                    break
            }
            if (currentState != state.currentState) {
            	//we have a state change
	            setVariable("\$previousState", currentState, true)
	            setVariable("\$previousStateSince", currentStateSince, true)
	            setVariable("\$previousStateDuration", state.currentStateSince - currentStateSince, true)
	            setVariable("\$currentState", state.currentState, true)
	            setVariable("\$currentStateSince", state.currentStateSince, true)
            }
        }
	} catch(all) {
    	debug "ERROR: An error occurred while processing event $evt: $all", null, "error"
    }
    perf = now() - perf
    if (evt) debug "Event processing took ${perf}ms", -1
}

private checkEventEligibility(condition, evt) {
	//we have a quad-state result
    // -2 means we're using triggers and the event does not match any of the used triggers
    // -1 means we're using conditions only and the event does not match any of the used conditions
    // 1 means we're using conditions only and the event does match at least one of the used conditions
    // 2 means we're using triggers and the event does match at least one of the used triggers
    // any positive value means the event is eligible for evaluation
	def result = -1 //assuming conditions only, no match
    if (condition) {
        if (condition.children != null) {
            //we're dealing with a group
            for (child in condition.children) {
                def v = checkEventEligibility(child, evt)
                switch (v) {
                	case -2:
                    	result = v
                    	break
                    case -1:
                    	break
                    case  1:
                    	if (result == -1) {
                        	result = v
                        }
                    	break
                    case  2:
	                	//if we already found a matching trigger, we're out
    	            	return v
                }
            }
        } else {
        	if (condition.trg) {
            	if (result < 2) {
                	//if we haven't already found a trigger
                	result = -2 // we are using triggers
                }
            }
            for (deviceId in condition.dev) {
                if ((evt.deviceId == deviceId) && (evt.name == condition.attr)) {
                	if (condition.trg) {
                    	//we found a trigger that matches the event, exit immediately
                    	return 2
                    } else {
                    	if (result == -1) {
                        	//we found a condition that matches the event, still looking for triggers though
                        	result = 1
                        }
                    }
                }
            }
        }
    }
    return result	
}



/******************************************************************************/
/*** CONDITION EVALUATION FUNCTIONS											***/
/******************************************************************************/

private evaluateConditionSet(evt, primary) {
	//executes whenever a device in the primary or secondary if block has an event
    def perf = now()
    def pushNote = null
    
    //debug "Event received by the ${primary ? "primary" : "secondary"} IF block evaluation for device ${evt.device}, attribute ${evt.name}='${evt.value}', isStateChange=${evt.isStateChange()}, currentValue=${evt.device.currentValue(evt.name)}, determining eligibility"
    //check for triggers - if the primary IF block has triggers and the event is not related to any trigger
    //then we don't want to evaluate anything, as only triggers should be executed
    //this check ensures that an event that is used in both blocks, but as different types, one as a trigger
    //and one as a condition do not interfere with each other
    def eligibilityStatus = checkEventEligibility(primary ? state.app.conditions: state.app.otherConditions , evt)
    def evaluation = null
    debug "Event eligibility for the ${primary ? "primary" : "secondary"} IF block is $eligibilityStatus  - ${eligibilityStatus > 0 ? "ELIGIBLE" : "INELIGIBLE"} (" + (eligibilityStatus == 2 ? "triggers required, event is a trigger" : (eligibilityStatus == 1 ? "triggers not required, event is a condition" : (eligibilityStatus == -2 ? "triggers required, but event is a condition" : "something is messed up"))) + ")"
    if (eligibilityStatus > 0) {
        evaluation = evaluateCondition(primary ? state.app.conditions: state.app.otherConditions, evt)
        //log.info "${primary ? "PRIMARY" : "SECONDARY"} EVALUATION IS $evaluation\n${getConditionDescription(primary ? 0 : -1)}\n"
        //pushNote = "${evt.device}.${evt.name} >>> ${evt.value}\n${primary ? "primary" : "secondary"} evaluation result: $evaluation\n\n${getConditionDescription(primary ? 0 : -1)}\n\nEvent received after ${perf - evt.date.getTime()}ms\n"
    } else {
    	//ignore the event
    }
    perf = now() - perf
	//if (pushNote) {
    	//sendPush(pushNote + "Event processed in ${perf}ms")
    //}
    return evaluation
}

private evaluateCondition(condition, evt) {
	//evaluates a condition
    def perf = now()  
    def result = false
    
    if (condition.children == null) {
    	//we evaluate a real condition here
        //several types of conditions, device, mode, SMH, time, etc.
        if (condition.attr == "time") {
        	result = evaluateTimeCondition(condition, evt)
        } else if (condition.dev && condition.dev.size()) {
        	result = evaluateDeviceCondition(condition, evt)
        }
        
        //apply the NOT, if needed
        result = condition.not ? !result : result
        //store variables
        if (condition.vd) setVariable(condition.vd, now())
        if (condition.vs) setVariable(condition.vs, result)
        if (condition.trg) {
            if (condition.vt && result) setVariable(condition.vt, evt.date.getTime())
            if (condition.vv && result) setVariable(condition.vv, evt.value)
            if (condition.vf && !result) setVariable(condition.vf, evt.date.getTime())        
            if (condition.vw && !result) setVariable(condition.vw, evt.value)
        }
        
    } else {
    	//we evaluate a group
        result = (condition.grp == "AND") //we need to start with a true when doing AND or with a false when doing OR/XOR
        for (child in condition.children) {
        	//evaluate the child
           	def subResult = evaluateCondition(child, evt)
            //apply it to the composite result
        	switch (condition.grp) {
            	case "AND":
                	result = result && subResult
                    break
            	case "OR":
                	result = result || subResult
                    break
            	case "XOR":
                	result = result ^ subResult
                    break
            }
        }
    }
    
    perf = now() - perf
	return result
}

private evaluateDeviceCondition(condition, evt) {
	//evaluates a condition   
    //we need true when dealing with All
    def mode = condition.mode == "All" ? "All" : "Any"
    def result =  mode == "All" ? true : false
    def currentValue = null
    
    //get list of devices
    def devices = settings["condDevices${condition.id}"]
    if (!devices) {
    	//something went wrong
        debug "ERROR: Something went wrong, we cannot find any devices for condition #${condition.id}", null, "error"
    	
    } else {
    	//the real deal goes here
        
        for (device in devices) {
			def comp = getComparisonOption(condition.attr, condition.comp)
            if (comp) {
            	//if event is about the same device/attribute, use the event's value as the current value, otherwise, fetch the current value from the device
                def deviceResult = false
                def ownsEvent = (evt.deviceId == device.id) && (evt.name == condition.attr)
                def oldValue = null
                def cache = atomicState.cache
				cache = cache ? cache : [:]
                def cachedValue = cache[device.id + "-" + condition.attr]
                if (cachedValue) oldValue = cachedValue.o
            	currentValue = ownsEvent ? evt.value : device.currentValue(condition.attr)
                def value1 = condition.var1 ? getVariable(condition.var1) : (condition.dev1 && settings["condDev${condition.id}#1"] ? settings["condDev${condition.id}#1"].currentValue(condition.attr) : condition.val1)
                def offset1 = condition.var1 || condition.dev1 ? condition.o1 : 0
                def value2 = condition.var2 ? getVariable(condition.var2) : (condition.dev2 && settings["condDev${condition.id}#2"] ? settings["condDev${condition.id}#2"].currentValue(condition.attr) : condition.val2)
                def offset2 = condition.var1 || condition.dev1 ? condition.o2 : 0
                //casting
				def attr = getAttributeByName(condition.attr)
                if (attr) {
                	switch (attr.type) {
                    	case "number":
                        	if (oldValue instanceof String) oldValue = oldValue.isInteger() ? oldValue.toInteger() : 0
                        	if (currentValue instanceof String) currentValue = currentValue.isInteger() ? currentValue.toInteger() : 0
							if (value1 instanceof String) value1 = value1.isInteger() ? value1.toInteger() : 0
							if (value2 instanceof String) value2 = value2.isInteger() ? value2.toInteger() : 0
                            value1 = o1 ? value1 + o1 : value1
                            value2 = o2 ? value2 + o2 : value2
                            break
                        case "decimal":
                        	if (oldValue instanceof String) oldValue = oldValue.isFloat() ? oldValue.isFloat() : 0
							if (currentValue instanceof String) currentValue = currentValue.isFloat() ? currentValue.toFloat() : 0
							if (value1 instanceof String) value1 = value1.isFloat() ? value1.toFloat() : 0
							if (value2 instanceof String) value2 = value2.isFloat() ? value1.toFloat() : 0
                            value1 = o1 ? value1 + o1 : value1
                            value2 = o2 ? value2 + o2 : value2
                        	break
                    }
                }
                if (condition.trg && !ownsEvent) {
                    //all triggers should own the event, otherwise be false
                    deviceResult = false
                } else {          
                	def function = "eval_" + (condition.trg ? "trg" : "cond") + "_" + condition.comp.replace(" ", "_")
					deviceResult = "$function"(condition, device, condition.attr, oldValue, currentValue, value1, value2, ownsEvent ? evt : null, evt)
                    debug "${deviceResult ? "♣" : "♠"} Function $function for $device's ${condition.attr} [$currentValue] ${condition.comp} $value1${comp.parameters == 2 ? " - $value2" : ""} returned $deviceResult"
                }
                
        		//compound the result, depending on mode
                def finalResult = false
        		switch (mode) {
	            	case "All":
	                	result = result && deviceResult
                        finalResult = !result
	                	break
	                case "Any":
	                	result = result || deviceResult
                        finalResult = result
	                	break
	            }
                //optimize the loop to exit when we find a result that's going to be the final one (AND encountered a false, or OR encountered a true)
                if (finalResult) break
            }
        }
        
    }

    return  result
}

private evaluateTimeCondition(condition, evt = null, unixTime = null) {
	//no condition? not time condition? false!
	if (!condition || (condition.attr != "time")) {
    	return false
    }
	//get UTC now if no unixTime is provided
	unixTime = unixTime ? unixTime : now()
    //convert that to location's timezone, for comparison
	def now = adjustTime(unixTime)
	def attr = getAttributeByName(condition.attr)
    def comparison = cleanUpComparison(condition.comp)
    def comp = getComparisonOption(condition.attr, comparison)    
    //if we can't find the attribute (can't be...) or the comparison object, or we're dealing with a trigger, exit stage false
    if (!attr || !comp) {
    	return false
    }
    
    if (comp.trigger == comparison) {
		//trigger
		if ((evt.deviceId == "time") && (evt.conditionId == condition.id)) {
        	condition.lt = evt.date.time
            //we have a time event returning as a result of a trigger, assume true
            return true
        } else {
        	return false
        }
	}

	//check comparison
    if (comparison.contains("any")) {
    	//we match any time
        result = true
    } else {
        //convert times to number of minutes since midnight for easy comparison
        def m = now ? now.getHours() * 60 + now.getMinutes() : 0
        def m1 = null
        def m2 = null
       	//go through each parameter
        def o1 = condition.o1 ? condition.o1 : 0
        def o2 = condition.o2 ? condition.o2 : 0
        for (def i = 1; i <= comp.parameters; i++) {
        	def val = i == 1 ? condition.val1 : condition.val2
            def t = null
            def v = 0
            switch (val) {
            	case "custom time":
                	t = condition.t1 ? adjustTime(condition.t1) : null
                    v = t ? t.getHours() * 60 + t.getMinutes() : null
                    if (!comparison.contains("around")) {
                        o1 = 0
                        o2 = 0
                    }
                   	break
				case "midnight":
                	v = (i == 1 ? 0 : 1440)
                    break
                case "sunrise":
                	t = getSunrise()
                    v = t ? t.getHours() * 60 + t.getMinutes() : null
                	break
				case "noon":
                	v = 12 * 60 //noon is 720 minutes away from midnight
                    break
                case "sunset":
                	t = getSunset()
                    v = t ? t.getHours() * 60 + t.getMinutes() : null
                	break
            }
            if (i == 1) {
            	m1 = v
            } else {
            	m2 = v
            }
        }
        if (comparison.contains("before")) {
        	if ((m1 == null) || (m >= addOffsetToMinutes(m1, o1))) {
        		//m before m1?
        		return false
            }
        }
        if (comparison.contains("after")) {
        	if ((m1 == null) || (m < addOffsetToMinutes(m1, o1))) {
        		//m after m1?
        		return false
            }
        }
        if (comparison.contains("around")) {
        	//if no offset, we can't really match anything
            if (!o1) {
            	return false
            }
        	def a1 = addOffsetToMinutes(m1, -o1)
        	def a2 = addOffsetToMinutes(m1, +o1)
            if (a1 < a2 ? (m < a1) || (m >= a2) : (m >= a1) && (m < a2)) {
        		return false
            }
        }       
        if (comparison.contains("between")) {
            def a1 = addOffsetToMinutes(m1, o1)
        	def a2 = addOffsetToMinutes(m2, o2)
            if (a1 < a2 ? (m < a1) || (m >= a2) : (m >= a1) && (m < a2)) {
        		return false
            }
        }
    }

	return result && testDateTimeFilters(condition, now)
}

private testDateTimeFilters(condition, now) {
	//if we made it this far, let's check on filters
    if (condition.fmh || condition.fhd || condition.fdw || condition.fdm || condition.fwm || condition.fmy || condition.fy) {
    	//check minute filter
        if (condition.fmh) {
        	def m = now.minutes.toString().padLeft(2, "0")
            if (!(m in condition.fmh)) {
            	return false
            }
		}

		//check hour filter
        if (condition.fhd) {
        	def h = formatHour(now.hours)
            if (!(h in condition.fhd)) {
            	return false
            }
		}
        
        if (condition.fdw) {
            def dow = getDayOfWeekName(now)
            if (!(dow in condition.fdw)) {
            	return false
            }
		}
        
        if (condition.fwm) {
        	def weekNo = "the ${formatOrdinalNumberName(getWeekOfMonth(now))} week"
            def lastWeekNo = "the ${formatOrdinalNumberName(getWeekOfMonth(now, reverse))} week"
            if (!((weekNo in condition.fwm) || (lastWeekNo in condition.fwm))) {
            	return false
            }
		}
		if (condition.fdm) {
        	def dayNo = "the " + formatOrdinalNumber(getDayOfMonth(now))
            def lastDayNo = "the " + formatOrdinalNumberName(getDayOfMonth(now, true)) + " day of the month"
            if (!((dayNo in condition.fdm) || (lastDayNo in condition.fdm))) {
            	return false
            }
		}

		if (condition.fmy) {
            if (!(getMonthName(now) in condition.fmy)) {
            	return false
            }
		}
        
        if (condition.fy) {
        	def year = now.year + 1900
            def yearOddEven = year.mod(2)
            def odd = "odd years" in condition.fy
            def even = "even years" in condition.fy
            def leap = "leap years" in condition.fy
            if (!(((yearOddEven == 0) && even) || ((yearOddEven == 1) && odd) || ((year.mod(4) == 0) && leap) || ("$year" in condition.fy))) {
            	return false
            }
        }
    }
    return true
}

/* low-level evaluation functions */
private eval_cond_is(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return eval_cond_is_equal_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt)
}

private eval_cond_is_not(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return eval_cond_is_not_equal_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt)
}

private eval_cond_is_equal_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return currentValue == value1
}

private eval_cond_is_not_equal_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return currentValue != value1
}

private eval_cond_is_less_than(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return currentValue < value1
}

private eval_cond_is_less_than_or_equal_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return currentValue <= value1
}

private eval_cond_is_greater_than(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return currentValue > value1
}

private eval_cond_is_greater_than_or_equal_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return currentValue >= value1
}

private eval_cond_is_even(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	if (currentValue.isInteger()) {
    	return currentValue.toInteger().mod(2) == 0
    }
	return false
}

private eval_cond_is_odd(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	if (currentValue.isInteger()) {
    	return currentValue.toInteger().mod(2) == 0
    }
	return false
}

private eval_cond_is_inside_range(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	if (value1 < value2) {
		return (currentValue >= value1) && (currentValue <= value2)
    } else {
		return (currentValue >= value2) && (currentValue <= value1)
    }
}

private eval_cond_is_outside_of_range(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	if (value1 < value2) {
		return (currentValue < value1) || (currentValue > value2)
	} else {
		return (currentValue < value2) || (currentValue > value1)
    }
}

private listPreviousStates(device, attribute, currentValue, minutes, excludeLast) {
//	def events = device.eventsSince(new Date(now() - minutes * 60000));
	def events = device.events([all: true, max: 100]).findAll{it.name == attribute}
    def result = []
    //if we got any events, let's go through them       
	//if we need to exclude last event, we start at the second event, as the first one is the event that triggered this function. The attribute's value has to be different from the current one to qualify for quiet
    def value = currentValue
    def thresholdTime = now() - minutes * 60000
    def endTime = now()
    for(def i = 0; i < events.size(); i++) {
    	def startTime = events[i].date.getTime()
    	def duration = endTime - startTime
        if ((duration >= 1000) && ((i > 0) || !excludeLast)) {
	        result.push([value: events[i].value, startTime: startTime, duration: duration])
        }
        if (startTime < thresholdTime)
	        break
        endTime = startTime
    }
    return result
}

private eval_cond_was(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return eval_cond_was_equal_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt)
}

private eval_cond_was_not(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	eval_cond_was_not_equal_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt)
}

private eval_cond_was_equal_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
    def time = timeToMinutes(condition.time)
	def states = listPreviousStates(device, attribute, currentValue, time, evt ? 1 : 0)
    def thresholdTime = time * 60000
    def stableTime = 0
    for (state in states) {
    	if (state.value == value1) {
        	stableTime += state.duration
        } else {
        	break
        }
    }
    return (stableTime > 0) && (condition.for == "for at least" ? stableTime >= thresholdTime : stableTime < thresholdTime)
}

private eval_cond_was_not_equal_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
    def time = timeToMinutes(condition.time)
	def states = listPreviousStates(device, attribute, currentValue, time, evt ? 1 : 0)
    def thresholdTime = time * 60000
    def stableTime = 0
    for (state in states) {
    	if (state.value != value1) {
        	stableTime += state.duration
        } else {
        	break
        }
    }
    return (stableTime > 0) && (condition.for == "for at least" ? stableTime >= thresholdTime : stableTime < thresholdTime)
}

private eval_cond_was_less_than(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
    def time = timeToMinutes(condition.time)
	def states = listPreviousStates(device, attribute, currentValue, time, evt ? 1 : 0)
    def thresholdTime = time * 60000
    def stableTime = 0
    for (state in states) {
    	if (state.value < value1) {
        	stableTime += state.duration
        } else {
        	break
        }
    }
    return (stableTime > 0) && (condition.for == "for at least" ? stableTime >= thresholdTime : stableTime < thresholdTime)
}

private eval_cond_was_less_than_or_equal_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
    def time = timeToMinutes(condition.time)
	def states = listPreviousStates(device, attribute, currentValue, time, evt ? 1 : 0)
    def thresholdTime = time * 60000
    def stableTime = 0
    for (state in states) {
    	if (state.value <= value1) {
        	stableTime += state.duration
        } else {
        	break
        }
    }
    return (stableTime > 0) && (condition.for == "for at least" ? stableTime >= thresholdTime : stableTime < thresholdTime)
}

private eval_cond_was_greater_than(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
    def time = timeToMinutes(condition.time)
	def states = listPreviousStates(device, attribute, currentValue, time, evt ? 1 : 0)
    def thresholdTime = time * 60000
    def stableTime = 0
    for (state in states) {
    	if (state.value > value1) {
        	stableTime += state.duration
        } else {
        	break
        }
    }
    return (stableTime > 0) && (condition.for == "for at least" ? stableTime >= thresholdTime : stableTime < thresholdTime)
}

private eval_cond_was_greater_than_or_equal_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
    def time = timeToMinutes(condition.time)
	def states = listPreviousStates(device, attribute, currentValue, time, evt ? 1 : 0)
    def thresholdTime = time * 60000
    def stableTime = 0
    for (state in states) {
    	if (state.value >= value1) {
        	stableTime += state.duration
        } else {
        	break
        }
    }
    return (stableTime > 0) && (condition.for == "for at least" ? stableTime >= thresholdTime : stableTime < thresholdTime)
}

private eval_cond_was_even(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
    def time = timeToMinutes(condition.time)
	def states = listPreviousStates(device, attribute, currentValue, time, evt ? 1 : 0)
    def thresholdTime = time * 60000
    def stableTime = 0
    for (state in states) {
    	if (state.value.isInteger() ? state.value.toInteger().mod(2) == 0 : false) {
        	stableTime += state.duration
        } else {
        	break
        }
    }
    return (stableTime > 0) && (condition.for == "for at least" ? stableTime >= thresholdTime : stableTime < thresholdTime)
}

private eval_cond_was_odd(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
    def time = timeToMinutes(condition.time)
	def states = listPreviousStates(device, attribute, currentValue, time, evt ? 1 : 0)
    def thresholdTime = time * 60000
    def stableTime = 0
    for (state in states) {
    	if (state.value.isInteger() ? state.value.toInteger().mod(2) == 1 : false) {
        	stableTime += state.duration
        } else {
        	break
        }
    }
    return (stableTime > 0) && (condition.for == "for at least" ? stableTime >= thresholdTime : stableTime < thresholdTime)
}

private eval_cond_was_inside_range(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
    def time = timeToMinutes(condition.time)
	def states = listPreviousStates(device, attribute, currentValue, time, evt ? 1 : 0)
    def thresholdTime = time * 60000
    def stableTime = 0
    for (state in states) {
    	if (value1 < value2 ? (state.value >= value1) && (state.value <= value2) : (state.value >= value2) && (state.value <= value1)) {
        	stableTime += state.duration
        } else {
        	break
        }
    }
    return (stableTime > 0) && (condition.for == "for at least" ? stableTime >= thresholdTime : stableTime < thresholdTime)
}

private eval_cond_was_outside_of_range(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
    def time = timeToMinutes(condition.time)
	def states = listPreviousStates(device, attribute, currentValue, time, evt ? 1 : 0)
    def thresholdTime = time * 60000
    def stableTime = 0
    for (state in states) {
    	if (value1 < value2 ? (state.value < value1) || (state.value > value2) : (state.value < value2) || (state.value > value1)) {
        	stableTime += state.duration
        } else {
        	break
        }
    }
    return (stableTime > 0) && (condition.for == "for at least" ? stableTime >= thresholdTime : stableTime < thresholdTime)
}

/* triggers */
private eval_trg_changes(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return oldValue != currentValue
}

private eval_trg_changes_to(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return !eval_cond_is_equal_to(condition, device, attribute, null, oldValue, value1, value2, evt, sourceEvt) &&
    		eval_cond_is_equal_to(condition, device, attribute, null, currentValue, value1, value2, evt, sourceEvt)
}

private eval_trg_changes_away_from(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return !eval_cond_is_not_equal_to(condition, device, attribute, null, oldValue, value1, value2, evt, sourceEvt) &&
    		eval_cond_is_not_equal_to(condition, device, attribute, null, currentValue, value1, value2, evt, sourceEvt)
}

private eval_trg_drops_below(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return !eval_cond_is_less_than(condition, device, attribute, null, oldValue, value1, value2, evt, sourceEvt) &&
    		eval_cond_is_less_than(condition, device, attribute, null, currentValue, value1, value2, evt, sourceEvt)
}

private eval_trg_drops_to_or_below(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return !eval_cond_is_less_than_or_equal_to(condition, device, attribute, null, oldValue, value1, value2, evt, sourceEvt) &&
    		eval_cond_is_less_than_or_equal_to(condition, device, attribute, null, currentValue, value1, value2, evt, sourceEvt)
}

private eval_trg_raises_above(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return !eval_cond_is_greater_than(condition, device, attribute, null, oldValue, value1, value2, evt, sourceEvt) &&
    		eval_cond_is_greater_than(condition, device, attribute, null, currentValue, value1, value2, evt, sourceEvt)
}

private eval_trg_raises_to_or_above(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return !eval_cond_is_greater_than_or_equal_to(condition, device, attribute, null, oldValue, value1, value2, evt, sourceEvt) &&
    		eval_cond_is_greater_than_or_equal_to(condition, device, attribute, null, currentValue, value1, value2, evt, sourceEvt)
}

private eval_trg_changes_to_even(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return !eval_cond_is_even(condition, device, attribute, null, oldValue, value1, value2, evt, sourceEvt) &&
    		eval_cond_is_even(condition, device, attribute, null, currentValue, value1, value2, evt, sourceEvt)
}

private eval_trg_changes_to_odd(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return !eval_cond_is_odd(condition, device, attribute, null, oldValue, value1, value2, evt, sourceEvt) &&
    		eval_cond_is_odd(condition, device, attribute, null, currentValue, value1, value2, evt, sourceEvt)
}

private eval_trg_enters_range(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return !eval_cond_is_inside_range(condition, device, attribute, null, oldValue, value1, value2, evt, sourceEvt) &&
    		eval_cond_is_inside_range(condition, device, attribute, null, currentValue, value1, value2, evt, sourceEvt)
}

private eval_trg_exits_range(condition, device, attribute, oldValue, currentValue, value1, value2, evt, sourceEvt) {
	return !eval_cond_is_outside_of_range(condition, device, attribute, null, oldValue, value1, value2, evt, sourceEvt) &&
    		eval_cond_is_outside_of_range(condition, device, attribute, null, currentValue, value1, value2, evt, sourceEvt)
}




/******************************************************************************/
/*** SCHEDULER FUNCTIONS - TIMING BELT										***/
/******************************************************************************/

private scheduleTimeTriggers() {
	debug "Rescheduling time triggers"
	withEachTrigger(state.app.conditions, "scheduleTimeTrigger")
	if (state.app.mode == "Latching") {
    	withEachTrigger(state.app.otherConditions, "scheduleTimeTrigger")
    }
}

private scheduleTimeTrigger(condition) {
	if (!condition || !(condition.attr) || (condition.attr != "time")) {
    	return
    }
    def time = getNextTimeTrigger(condition, condition.lt)
    condition.nt = time
    scheduleTask("evt", condition.id, null, time)
}

private scheduleTask(task, ownerId, deviceId, unixTime, data = null) {
	if (!unixTime) return false
	if (!state.tasker) state.tasker = []
    state.tasker.push([add: task, ownerId: ownerId, deviceId: deviceId, data: data, time: unixTime, created: now()])
    return true
}

private unscheduleTask(taskType, ownerId, deviceId) {
	if (!state.tasker) state.tasker = []
   state.tasker.push([del: task, ownerId: ownerId, deviceId: deviceId, created: now()])
}

private getNextTimeTrigger(condition, startTime = null) {
	//no condition? not time condition? false!
	if (!condition || (condition.attr != "time")) {
    	return null
    }
	//get UTC now if no unixTime is provided
	def unixTime = startTime ? startTime : now()
    //convert that to location's timezone, for comparison
	def now = adjustTime(unixTime)
	def attr = getAttributeByName(condition.attr)
    def comparison = cleanUpComparison(condition.comp)
    def comp = getComparisonOption(condition.attr, comparison)    
    //if we can't find the attribute (can't be...) or the comparison object, or we're not dealing with a trigger, exit stage null
    if (!attr || !comp || comp.trigger != comparison) {
    	return null
    }
    
    def repeat = (condition.val1 && condition.val1.contains("every") ? condition.val1 : condition.r)
    if (!repeat) {
    	return null
	}
    def interval = (repeat.contains("number") ? (condition.val1 && condition.val1.contains("every") ? condition.e : condition.re) : 1)
    if (!interval) {
    	return null
	}
    repeat = repeat.replace("every ", "").replace("number of ", "").replace("s", "")
	//do the work
    def maxCycles = null
	while ((maxCycles == null) || (maxCycles > 0)) {
        def cycles = null
	    def repeatCycle = false
        if (repeat == "minute") {
            //increment minutes
            now = new Date(now.time + interval * 60000)
            cycles = 1440
        } else if (repeat == "hour") {
            //increment hours
            def m = now.minutes
            def rm = (condition.m ? condition.m : "0").toInteger()
            now = new Date(now.time + (m < rm ? interval - 1 : interval) * 3600000)
            now = new Date(now.year, now.month, now.date, now.hours, rm, 0)
            cycles = 744
        } else {
            //we're repeating at a granularity larger or equal to a day
            //we need the time of the day at which things happen
            def h = 0
            def m = 0
            def offset = 0
            def customTime = null
            switch (condition.val1) {
                case "custom time":
                    if (!condition.t1) {
                        return null
                    }
                    customTime = adjustTime(condition.t1)
                    break
                case "sunrise":
                    customTime = getSunrise()
                    offset = condition.o1 ? condition.o1 : 0
                    break
                case "sunset":
                    customTime = getSunset()
                    offset = condition.o1 ? condition.o1 : 0
                    break
                case "noon":
                    h = 12
                    offset = condition.o1 ? condition.o1 : 0
                    break
                case "midnight":
                    offset = condition.o1 ? condition.o1 : 0
                    break
            }
            
            if (customTime) {
                h = customTime.hours
                m = customTime.minutes
            }
            //we now have the time of the day
            //let's figure out the next day

            //we need a - one day offset if now is before the required time
            //since today could still be a candidate
            now = (now.hours * 60 - h * 60 + now.minutes - m - offset < 0) ? now - 1 : now
            now = new Date(now.year, now.month, now.date, h, m, 0)
            
            //apply the offset
            if (offset) {
            	now = new Date(now.time + offset * 60000)
            }

            switch (repeat) {
                case "day":
                    now = now + interval
                    cycles = 1095
                    break
                case "week":
                    def dow = now.day
                    def rdow = getDayOfWeekNumber(condition.rdw)
                    if (rdow == null) {
                        return null
                    }
                    now = now + (rdow <= dow ? rdow + 7 - dow : rdow - dow) + (interval - 1) * 7            	
                    cycles = 520
                    break
                case "month":
                	def day = condition.rd
                    if (!day) {
                    	return null
                    }
                    if (day.contains("week")) {
                        def rdow = getDayOfWeekNumber(condition.rdw)
                        if (rdow == null) {
                            return null
                        }
                    	//we're using Nth week day of month
                        def week = 1
						if (day.contains("first")) {
                        	week = 1
                        } else if (day.contains("second")) {
                        	week = 2
                        } else if (day.contains("third")) {
                        	week = 3
                        } else if (day.contains("fourth")) {
                        	week = 4
                        } else if (day.contains("fifth")) {
                        	week = 5
                        }
                        if (day.contains("last")) {
                            week = -week
                        }
                        def intervalOffset = 0
                        def d = getDayInWeekOfMonth(now, week, rdow)
                        //get a possible date this month
                        if (d && (new Date(now.year, now.month, d, now.hours, now.minutes, 0) > now)) {
                            //at this point, the next month is this month (lol), we need to remove one from the interval
                            intervalOffset = 1
                        }

                        //get the day of the next required month
                        d = getDayInWeekOfMonth(new Date(now.year, now.month + interval - intervalOffset, 1, now.hours, now.minutes, 0), week, rdow)
                        if (d) {
	                        now = new Date(now.year, now.month + interval - intervalOffset, d, now.hours, now.minutes, 0)
                        } else {
                        	now = new Date(now.year, now.month + interval - intervalOffset, 1, now.hours, now.minutes, 0)
                            repeatCycle = true
                        }
                    } else {
                    	//we're specifying a day
	                    def d = 1
                        if (day.contains("last")) {
                        	//going backwards
                            if (day.contains("third")) {
                            	d = -2
                            } else if (day.contains("third")) {
                            	d = -1
                            } else {
                            	d = 0
                            }
                        	def intervalOffset = 0                            
                            //get the last day of this month
                            def dd = (new Date(now.year, now.month + 1, d)).date
                            if (new Date(now.year, now.month, dd, now.hours, now.minutes, 0) > now) {
                                //at this point, the next month is this month (lol), we need to remove one from the interval
                                intervalOffset = 1
                            }
                            //get the day of the next required month
                            d = (new Date(now.year, now.month + interval - intervalOffset + 1, d)).date
                            now = new Date(now.year, now.month + interval - intervalOffset, d, now.hours, now.minutes, 0)
                        } else {
                        	//the day is in the string
                        	day = day.replace("on the ", "").replace("st", "").replace("nd", "").replace("rd", "").replace("th", "")
                            if (!day.isInteger()) {
                            	//error
                            	return null
                            }                            
                            d = day.toInteger()
							now = new Date(now.year, now.month + interval - (d > now.date ? 1 : 0), d, now.hours, now.minutes, 0)
							if (d > now.date) {
                            	//we went overboard, this month does not have so many days, repeat the cycle to move on to the next month that does
                                repeatCycle = true
                            }
                        }
                    }
                    cycles = 36
                    break
                case "year":
                	def day = condition.rd
                    if (!day) {
                    	return null
                    }
                    if (!condition.rm) {
                        return null
                    }
                    def mo = getMonthNumber(condition.rm)
                    if (mo == null) {
                    	return null
                    }
                    mo--                   
                    if (day.contains("week")) {
                        def rdow = getDayOfWeekNumber(condition.rdw)
                        if (rdow == null) {
                            return null
                        }
                    	//we're using Nth week day of month
                        def week = 1
						if (day.contains("first")) {
                        	week = 1
                        } else if (day.contains("second")) {
                        	week = 2
                        } else if (day.contains("third")) {
                        	week = 3
                        } else if (day.contains("fourth")) {
                        	week = 4
                        } else if (day.contains("fifth")) {
                        	week = 5
                        }
                        if (day.contains("last")) {
                            week = -week
                        }
                        def intervalOffset = 0
                        def d = getDayInWeekOfMonth(new Date(now.year, mo, now.date, now.hours, now.minutes, 0), week, rdow)
                        //get a possible date this year
                        if (d && (new Date(now.year, mo, d, now.hours, now.minutes, 0) > now)) {
                            //at this point, the next month is this month (lol), we need to remove one from the interval
                            intervalOffset = 1
                        }

                        //get the day of the next required month
                        d = getDayInWeekOfMonth(new Date(now.year + interval - intervalOffset, mo, 1, now.hours, now.minutes, 0), week, rdow)
                        if (d) {
	                        now = new Date(now.year + interval - intervalOffset, mo, d, now.hours, now.minutes, 0)
                        } else {
                        	now = new Date(now.year + interval - intervalOffset, mo, 1, now.hours, now.minutes, 0)
                            repeatCycle = true
                        }
                    } else {
                    	//we're specifying a day
	                    def d = 1
                        if (day.contains("last")) {
                        	//going backwards
                            if (day.contains("third")) {
                            	d = -2
                            } else if (day.contains("third")) {
                            	d = -1
                            } else {
                            	d = 0
                            }
                        	def intervalOffset = 0                            
                            //get the last day of specified month
                            def dd = (new Date(now.year, mo + 1, d)).date
                            if (new Date(now.year, mo, dd, now.hours, now.minutes, 0) > now) {
                                //at this point, the next month is this month (lol), we need to remove one from the interval
                                intervalOffset = 1
                            }
                            //get the day of the next required month
                            d = (new Date(now.year + interval - intervalOffset, mo + 1, d)).date
                            now = new Date(now.year + interval - intervalOffset, mo, d, now.hours, now.minutes, 0)
                        } else {
                        	//the day is in the string
                        	day = day.replace("on the ", "").replace("st", "").replace("nd", "").replace("rd", "").replace("th", "")
                            if (!day.isInteger()) {
                            	//error
                            	return null
                            }                            
                            d = day.toInteger()
							now = new Date(now.year + interval - ((d > now.date) && (now.month == mo) ? 1 : 0), mo, d, now.hours, now.minutes, 0)
							if (d > now.date) {
                            	//we went overboard, this month does not have so many days, repeat the cycle to move on to the next month that does
                                if (d > 29) {
                                	//no year ever will have this day on the selected month
                                    return null
                                }
                                repeatCycle = true
                            }
                        }
                    }
                    cycles = 10
                    break
            }
        }
		//check if we have to repeat or exit
		if ((!repeatCycle) && testDateTimeFilters(condition, now)) {
            //make it UTC Unix Time
            def result = convertDateToUnixTime(now)
            //we only provide a time in the future
            //if we weren't, we'd be hogging everyone trying to keep up
            if (result >= (new Date()).time) {
            	return result
            }
        }       
        maxCycles = (maxCycles == null ? cycles : maxCycles) - 1
	}
}

private processTasks() {
	//pfew, off to process tasks
    //first, we make a variable to help us pick up where we left off
    def tasks = null
    def perf = now()
    debug "Processing tasks", 1

	def safetyNet = false

    //let's give now() a 2s bump up so that if anything is due within 2s, we do it now rather than scheduling ST
    def threshold = 2000
    
	//we're off to process any pending immediate events
    //we loop a seemingly infinite loop
    //no worries, we'll break out of it, maybe :)
    while (true) {
        //we need to read the list every time we get here because the loop itself takes time.
        //we always need to work with a fresh list. Using a ? would not read the list the first time around (optimal, right?)
        tasks = tasks ? tasks : atomicState.tasks
		tasks = tasks ? tasks : [:]
        for (item in tasks) {
            def task = item.value
            if ((task.type == "evt") && (task.time <= now() + threshold)) {
                //remove from tasks
                tasks.remove(item.key)
                atomicState.tasks = tasks
                state.tasks = tasks
                //throw away the task list as this procedure below may take time, making our list stale
                //not to worry, we'll read it again on our next iteration
                tasks = null
                //since we may timeout here, install the safety net
                safetyNet = true
			    debug "Installing ST safety net"
			    runIn(90, recoveryHandler)
                //trigger an event
                if (getCondition(task.ownerId, true)) {
	                //look for condition in primary block
	                debug "Broadcasting time event for primary IF block, condition #${task.ownerId}, task = $task"
					broadcastEvent([name: "time", date: new Date(task.time), deviceId: "time", conditionId: task.ownerId], true, false)
                } else if (getCondition(task.ownerId, false)) {
	                //look for condition in secondary block
	                debug "Broadcasting time event for secondary IF block, condition #${task.ownerId}"
					broadcastEvent([name: "time", date: new Date(task.time), deviceId: "time", conditionId: task.ownerId], false, true)
                } else {
	                debug "ERROR: Time event cannot be processed because condition #${task.ownerId} does not exist", null, "error"
                }
                //continue the loop
                break
            }
        }
        //well, if we got here, it means there's nothing to do anymore
        if (tasks != null) break
    }
  
  	//okay, now let's give the time triggers a chance to readjust
    scheduleTimeTriggers()

	//read the tasks
    tasks = atomicState.tasks
    tasks = tasks ? tasks : [:]
    //then if there's any pending tasks in the tasker, we look them up too and merge them to the task list
    if (state.tasker && state.tasker.size()) {
        for (task in state.tasker) {
            if (task.add) {
                //add a task
                def t = [type: task.add, ownerId: task.ownerId, deviceId: task.deviceId, time: task.time, created: task.created]
                def n = "${task.add}:${task.ownerId}${task.deviceId ? ":${task.deviceId}" : ""}"
                tasks[n] = t
            } else if (task.del) {
                //delete a task
                def n = "${task.task}:${task.ownerId}${task.deviceId ? ":${task.deviceId}" : ""}"
                tasks.remove(n)
            }
        }
        //we save the tasks list atomically, ouch
        //this is to avoid spending too much time with the tasks list on our hands and having other instances
        //running and modifying the old list that we picked up above
        state.tasksProcessed = now()
        atomicState.tasks = tasks
        state.tasks = tasks
		state.tasker = []
    }
    
	//time to see if there is any ST schedule needed for the future
	def nextTime = null
    def immediateTasks = 0
    def thresholdTime = now() + threshold
    for (item in tasks) {
    	def task = item.value
        //if a task is already due, we keep track of it
    	if (task.time <= thresholdTime) {
        	immediateTasks++
		} else {
        	//we try to get the nearest time in the future
	    	nextTime = (nextTime == null) || (nextTime > task.time) ? task.time : nextTime
        }
    }
    //if we found a time that's after 
    if (nextTime) {
    	def seconds = Math.round((nextTime - now()) / 1000)
    	runIn(seconds, timeHandler)
        state.nextScheduledTime = nextTime
        setVariable("\$nextScheduledTime", nextTime, true)
    	debug "Scheduling ST to run in ${seconds}s, at ${formatLocalTime(nextTime)}"
    }

	//we're done with the scheduling, let's do some real work, if we have any
    if (immediateTasks) {
    	if (!safetyNet) {
        	//setup a safety net ST schedule to resume the process if we fail
            safetyNet = true
        	debug "Installing ST safety net"
        	runIn(90, recoveryHandler)
        }
    
		debug "Found $immediateTasks task${immediateTasks > 1 ? "s" : ""} due at this time"
        //we loop a seemingly infinite loop
        //no worries, we'll break out of it, maybe :)
        while (true) {
            //we need to read the list every time we get here because the loop itself takes time.
            //we always need to work with a fresh list. Using a ? would not read the list the first time around (optimal, right?)
            tasks = tasks ? tasks : atomicState.tasks
		    tasks = tasks ? tasks : [:]
            for (item in tasks) {
                def task = item.value
                if ((task.type != "evt") && (task.time <= (now() + threshold))) {
                    //remove from tasks
                    tasks = atomicState.tasks
                    debug "Removing task ${item.key}"
                    tasks.remove(item.key)
                    debug "Saving atomic state tasks: $tasks"
                    atomicState.tasks = tasks
                    //throw away the task list as this procedure below may take time, making our list stale
                    //not to worry, we'll read it again on our next iteration
                    tasks = null
                    //do some work
                    if (task.type == "cmd") {
                    	debug "Processing command task $task"
                    	processCommandTask(task)
                    }
                    //continue the loop
                    continue
                }
            }
            //well, if we got here, it means there's nothing to do anymore
            break
        }
    }
    //would you look at that, we finished!
    //remove the safety net, wasn't worth the investment
    debug "Removing any existing ST safety nets"
    unschedule(recoveryHandler)
	//end of processTasks
	perf = now() - perf
    debug "Task processing took ${perf}ms", -1    
}


//the heavy lifting of commands
//this executes each and every single command we have to give
private processCommandTask(task) {
	return true
}











/******************************************************************************/
/*** CoRE PISTON PUBLISHED METHODS											***/
/******************************************************************************/

def getLastPrimaryEvaluationDate() {
	return state.lastPrimaryEvaluationDate
}

def getLastPrimaryEvaluationResult() {
	return state.lastPrimaryEvaluationResult
}

def getLastSecondaryEvaluationDate() {
	return state.lastSecondaryEvaluationDate
}

def getLastSecondaryEvaluationResult() {
	return state.lastSecondaryEvaluationResult
}

def getCurrentState() {
	return state.currentState
}

def getMode() {
	return state.app  ? state.app.mode : null
}

def getDeviceSubscriptionCount() {
	return state.deviceSubscriptions ? state.deviceSubscriptions : 0
}

def getCurrentStateSince() {
	return state.currentStateSince
}

def getRunStats() {
	return state.runStats
}

def resetRunStats() {
    atomicState.runStats = null
	state.runStats = null
}

def getConditionStats() {
	return [
    	conditions: getConditionCount(state.app),
        triggers: getTriggerCount(state.app)
    ]
}





/******************************************************************************/
/***																		***/
/*** UTILITIES																***/
/***																		***/
/******************************************************************************/

/******************************************************************************/
/*** DEBUG FUNCTIONS														***/
/******************************************************************************/

private debug(message, shift = null, cmd = null) {
	if (!settings.debugging) {
    	return
    }
    
    //mode is
    // 0 - initialize level, level set to 1
    // 1 - start of routine, level up
    // -1 - end of routine, level down
    // anything else - nothing happens
    def maxLevel = 4
    def level = state.debugLevel ? state.debugLevel : 0
    def levelDelta = 0
    def prefix = "║"
    def pad = "░"
    switch (shift) {
    	case 0:
        	level = 0
            prefix = ""
            break
        case 1: 
        	level += 1
            prefix = "╚"
            pad = "═"
            break
        case -1:
        	levelDelta = -(level > 0 ? 1 : 0)
            pad = "═"
            prefix = "╔"
        break
    }
    
    if (level > 0) {
    	prefix = prefix.padLeft(level, "║").padRight(maxLevel, pad)
    }

    level += levelDelta
    state.debugLevel = level

	if (cmd == "info") {
		log.info "$prefix $message"
    } else if (cmd == "trace") {
		log.trace "$prefix $message"
    } else if (cmd == "warn") {
		log.warn "$prefix $message"
    } else if (cmd == "error") {
		log.error "$prefix $message"
    } else {
		log.debug "$prefix $message"
    }
}


/******************************************************************************/
/*** DATE & TIME FUNCTIONS													***/
/******************************************************************************/
private getPreviousQuarterHour(unixTime = now()) {
	return unixTime - unixTime.mod(900000)
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
	if (time instanceof String) {
    	//get UTC time
    	time = timeToday(time, location.timeZone)
    }   
    if (!(time instanceof Date)) {
    	return null
    }
	def formatter = new java.text.SimpleDateFormat(format)
	formatter.setTimeZone(location.timeZone)
	return formatter.format(time)
}

private convertDateToUnixTime(date) {
	return date.time - location.timeZone.getOffset(date.time)
}

private formatTime(time) {
	//we accept both a Date or a settings' Time    
    return formatLocalTime(time, "h:mm a z")
}

private formatHour(h) {
	return (h == 0 ? "midnight" : (h < 12 ? "${h} AM" : (h == 12 ? "noon" : "${h-12} PM"))).toString()
}

private formatDayOfMonth(dom, dow) {
	if (dom) {
    	if (dom.contains("week")) {
        	//relative day of week
            return dom.replace("week", dow)
        } else {
        	//dealing with a certain day of the month
            if (dom.contains("last")) {
            	//relative day value
                return dom
            } else {           	
            	//absolute day value
                def day = dom.replace("on the ", "").replace("st", "").replace("nd", "").replace("rd", "").replace("th", "").toInteger()
                return "on the ${formatOrdinalNumber(day)}"
            }
        }
    }
    return "[ERROR]"
}

//return the number of occurrences of same day of week up until the date or from the end of the month if backwards, i.e. last Sunday is -1, second-last Sunday is -2
private getWeekOfMonth(date = null, backwards = false) {
	if (!date) {
    	date = adjustTime(now())
    }
	def day = date.date
    if (backwards) {
        def month = date.month
        def year = date.year
        def lastDayOfMonth = (new Date(year, month + 1, 0)).date
        return -(1 + Math.floor((lastDayOfMonth - day) / 7))
    } else {
		return 1 + Math.floor((day - 1) / 7) //1 based
    }
}

//returns the number of day in a month, 1 based, or -1 based if backwards (last day of the month)
private getDayOfMonth(date = null, backwards = false) {
	if (!date) {
    	date = adjustTime(now())
    }
	def day = date.date
    if (backwards) {
        def month = date.month
        def year = date.year
        def lastDayOfMonth = (new Date(year, month + 1, 0)).date
        return day - lastDayOfMonth - 1
    } else {
		return day
    }
}

//for a given month, returns the Nth instance of a certain day of the week within that month. week ranges from 1 through 5 and -1 through -5
private getDayInWeekOfMonth(date, week, dow) {
	if (!date || (dow == null)) {
    	return null
    }
    def lastDayOfMonth = (new Date(date.year, date.month + 1, 0)).date
	if (week > 0) {
    	//going forward
        def firstDayOfMonthDOW = (new Date(date.year, date.month, 1)).day
        //find the first matching day
        def firstMatch = 1 + dow - firstDayOfMonthDOW + (dow < firstDayOfMonthDOW ? 7 : 0)
        def result = firstMatch + 7 * (week - 1)
        return result <= lastDayOfMonth ? result : null
    }
    if (week < 0) {
    	//going backwards
        def lastDayOfMonthDOW = (new Date(date.year, date.month + 1, 0)).day
        //find the first matching day
        def firstMatch = lastDayOfMonth + dow - lastDayOfMonthDOW - (dow > lastDayOfMonthDOW ? 7 : 0)
        def result = firstMatch + 7 * (week + 1)
        return result >= 1 ? result : null
    }
    return null
}

private getDayOfWeekName(date = null) {
	if (!date) {
    	date = adjustTime(now())
    }
    switch (date.day) {
    	case 0: return "Sunday"
    	case 1: return "Monday"
    	case 2: return "Tuesday"
    	case 3: return "Wednesday"
    	case 4: return "Thursday"
    	case 5: return "Friday"
    	case 6: return "Saturday"
    }
    return null
}

private getDayOfWeekNumber(date = null) {
	if (!date) {
    	date = adjustTime(now())
    }
    if (date instanceof Date) {
    	return date.day
    }
    switch (date) {
    	case "Sunday": return 0
    	case "Monday": return 1
    	case "Tuesday": return 2
    	case "Wednesday": return 3
    	case "Thursday": return 4
    	case "Friday": return 5
    	case "Saturday": return 6
    }
    return null
}

private getMonthName(date = null) {
	if (!date) {
    	date = adjustTime(now())
    }
    def month = date.month + 1
    switch (month) {
    	case  1: return "January"
    	case  2: return "February"
    	case  3: return "March"
    	case  4: return "April"
    	case  5: return "May"
    	case  6: return "June"
    	case  7: return "July"
    	case  8: return "August"
    	case  9: return "September"
    	case 10: return "October"
    	case 11: return "November"
    	case 12: return "December"
    }
    return null
}

private getMonthNumber(date = null) {
	if (!date) {
    	date = adjustTime(now())
    }
    if (date instanceof Date) {
    	return date.month + 1
    }
    switch (date) {
    	case "January": return 1
    	case "February": return 2
    	case "March": return 3
    	case "April": return 4
    	case "May": return 5
    	case "June": return 6
    	case "July": return 7
        case "August": return 8
    	case "September": return 9
    	case "October": return 10
    	case "November": return 11
    	case "December": return 12
    }
    return null
}
private getSunrise() {
	if (!(state.sunrise instanceof Date)) {
    	def sunTimes = getSunriseAndSunset()
        state.sunrise = adjustTime(sunTimes.sunrise)
        state.sunset = adjustTime(sunTimes.sunset)
    }
    return state.sunrise
}

private getSunset() {
	if (!(state.sunset instanceof Date)) {
    	def sunTimes = getSunriseAndSunset()
        state.sunrise = adjustTime(sunTimes.sunrise)
        state.sunset = adjustTime(sunTimes.sunset)
    }
    return state.sunset
}

private addOffsetToMinutes(minutes, offset) {
	if (minutes == null) {
    	return null
    }
	if (offset == null) {
    	return minutes
    }
	minutes = minutes + offset
    while (minutes >= 1440) {
    	minutes -= 1440
    }
    while (minutes < 0) {
    	minutes += 1440
    }
    return minutes
}

private timeComparisonOptionValues(trigger) {
   	return ["custom time", "midnight", "sunrise", "noon", "sunset", "time of variable", "date and time of variable"] + (trigger ? ["every minute", "every number of minutes", "every hour", "every number of hours"] : [])
}

private timeOptions() {
	def result = ["1 minute"]
    for (def i =2; i <= 60; i++) {
    	result.push("$i minutes")
    }
	return result
}

private timeRepeatOptions() {
	return ["every day", "every number of days", "every week", "every number of weeks", "every month", "every number of months", "every year", "every number of years"]
}

private timeMinuteOfHourOptions() {
	def result = []
    for (def i =0; i <= 59; i++) {
    	result.push("$i".padLeft(2, "0"))
    }
	return result
}

private timeHourOfDayOptions() {
	def result = []
    for (def i =0; i <= 23; i++) {
    	result.push(formatHour(i))
    }
	return result
}

private timeDayOfMonthOptions() {
	def result = []
    for (def i =1; i <= 31; i++) {
    	result.push("on the ${formatOrdinalNumber(i)}")
    }
	return result + ["on the last day", "on the second-last day", "on the third-last day", "on the first week", "on the second week", "on the third week", "on the fourth week", "on the fifth week", "on the last week", "on the second-last week", "on the third-last week"]
}

private timeDayOfMonthOptions2() {
	def result = []
    for (def i =1; i <= 31; i++) {
    	result.push("the ${formatOrdinalNumber(i)}")
    }
	return result + ["the last day of the month", "the second-last day of the month", "the third-last day of the month"]
}

private timeDayOfWeekOptions() {
	return ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
}

private timeWeekOfMonthOptions() {
	return ["the first week", "the second week", "the third week", "the fourth week", "the fifth week", "the last week", "the second-last week"]
}

private timeMonthOfYearOptions() {
	return ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
}

private timeYearOptions() {
	def result = ["even years", "odd years", "leap years"]
    def year = 1900 + (new Date()).getYear()
    for (def i = year; i <= 2099; i++) {
    	result.push("$i")
    }
    for (def i = 2016; i < year; i++) {
    	result.push("$i")
    }
    return result
}

private timeToMinutes(time) {
	def value = time.replace(" minutes", "").replace(" minute", "")
    if (value.isInteger()) {
    	return value.toInteger()
    }
    return 0
}





/******************************************************************************/
/*** NUMBER FUNCTIONS														***/
/******************************************************************************/

private formatOrdinalNumber(number) {
	def hm = number.mod(100)
    if ((hm < 10) || (hm > 20)) {
        switch (number.mod(10)) {
            case 1:
                return "${number}st"
            case 2:
                return "${number}nd"
            case 3:
                return "${number}rd"
        }
    }
	return "${number}th"
}

private formatOrdinalNumberName(number) {
	def prefix = ""
    if ((number >= 100) || (number <= -100)) {
    	return "NOT_IMPLEMENTED"
    }
    if (number < -1) {
    	return formatOrdinalNumberName(-number) + "-last"
    }
    if (number >= 20) {
    	def tens = Math.floor(number / 10)
        switch (tens) {
        	case 2:
            	prefix = "twenty"
                break
        	case 3:
            	prefix = "thirty"
                break
        	case 4:
            	prefix = "fourty"
                break
        	case 5:
            	prefix = "fifty"
                break
        	case 6:
            	prefix = "sixty"
                break
        	case 7:
            	prefix = "seventy"
                break
        	case 8:
            	prefix = "eighty"
                break
        	case 9:
            	prefix = "ninety"
                break
        }
        if (prefix) {
        	if (number.mod(10) > 0) {
            	prefix = prefix + "-"
            }
            number = number - tens * 10
        }
    }
	switch (number) {
    	case -1: return "${prefix}last"
        case 0: return prefix
    	case 1: return "${prefix}first"
    	case 2: return "${prefix}second"
    	case 3: return "${prefix}third"
    	case 4: return "${prefix}fourth"
    	case 5: return "${prefix}fifth"
    	case 6: return "${prefix}sixth"
    	case 7: return "${prefix}seventh"
    	case 8: return "${prefix}eighth"
    	case 9: return "${prefix}nineth"
    	case 10: return "${prefix}tenth"
    	case 11: return "${prefix}eleventh"
    	case 12: return "${prefix}twelveth"
    	case 13: return "${prefix}thirteenth"
    	case 14: return "${prefix}fourteenth"
    	case 15: return "${prefix}fifteenth"
    	case 16: return "${prefix}sixteenth"
    	case 17: return "${prefix}seventeenth"
    	case 18: return "${prefix}eighteenth"
    	case 19: return "${prefix}nineteenth"
    }
}









/******************************************************************************/
/*** CONDITION FUNCTIONS													***/
/******************************************************************************/

//finds and returns the condition object for the given condition Id
private _traverseConditions(parent, conditionId) {
    if (parent.id == conditionId) {
        return parent
    }
    for (condition in parent.children) {
        def result = _traverseConditions(condition, conditionId)
        if (result) {
            return result
        }
    }
    return null
}

//returns a condition based on its ID
private getCondition(conditionId, primary = null) {
	def result = null
    def parent = (state.run == "config" ? state.config : state)
    if (parent && (primary in [null, true]) && parent.app && parent.app.conditions) {
    	result =_traverseConditions(parent.app.conditions, conditionId)
    }
    if (!result && parent && (primary in [null, false]) && parent.app && parent.app.otherConditions) {
    	result = _traverseConditions(parent.app.otherConditions, conditionId)
    }
	return result
}

//optimized version that returns true if any trigger is detected
private getConditionHasTriggers(condition) {
	def result = 0
    if (condition) {
        if (condition.children != null) {
            //we're dealing with a group
            for (child in condition.children) {
                if (getConditionHasTriggers(child)) {
                	//if we detect a trigger we exit immediately
                	return true
                }
            }
        } else {
        	return !!condition.trg
        }
    }
    return false
}

private getConditionTriggerCount(condition) {
	def result = 0
    if (condition) {
        if (condition.children != null) {
            //we're dealing with a group
            for (child in condition.children) {
                result += getConditionTriggerCount(child)
            }
        } else {
        	if (condition.trg) {
            	def devices = settings["condDevices${condition.id}"]
                if (devices) {
                	return devices.size()
                } else {
                	return 1
                }
            }
        }
    }
    return result
}

private withEachTrigger(condition, callback) {
	def result = 0
    if (condition) {
        if (condition.children != null) {
            //we're dealing with a group
            for (child in condition.children) {
                withEachTrigger(child, callback)
            }
        } else {
        	if (condition.trg) {
            	"$callback"(condition)
            }
        }
    }
    return result
}

private getTriggerCount(app) {
	return getConditionTriggerCount(app.conditions) + (settings.mode == "Latching" ? getConditionTriggerCount(app.otherConditions) : 0)
}

private getConditionConditionCount(condition) {
	def result = 0
    if (condition) {
        if (condition.children != null) {
            //we're dealing with a group
            for (child in condition.children) {
                result += getConditionConditionCount(child)
            }
        } else {
        	if (!condition.trg) {
            	def devices = settings["condDevices${condition.id}"]
                if (devices) {
                	return devices.size()
                } else {
                	return 1
                }
            }
        }
    }
    return result
}

private getConditionCount(app) {
	return getConditionConditionCount(app.conditions) + (settings.mode == "Latching" ? getConditionConditionCount(app.otherConditions) : 0)
}

//cleans up conditions - this may be replaced by a complete rebuild of the app object from the settings
private cleanUpConditions(deleteGroups) {
	//go through each condition in the state config and delete it if no associated settings exist
    _cleanUpCondition(state.config.app.conditions, deleteGroups)
    _cleanUpCondition(state.config.app.otherConditions, deleteGroups)
}

//helper function for _cleanUpConditions
private _cleanUpCondition(condition, deleteGroups) {
	def result = false

	if (condition.children) {
    	//we cannot use a for each due to concurrent modifications
        //we're using a while instead
        def deleted = true
        while (deleted) {
        	deleted = false
			for (def child in condition.children) {
            	deleted = _cleanUpCondition(child, deleteGroups)
	    		result = result || deleted
                if (deleted) {
                	break
                }
            }
		}
    }

	//if non-root condition
	if (condition.id > 0) {
    	if (condition.children == null) {
        	//if regular condition
        	if ((condition.cap != "Location Mode") && (condition.cap != "Smart Home Monitor") && (condition.cap != "Date & Time") && settings["condDevices${condition.id}"] == null) {
	        	deleteCondition(condition.id);
	            return true
	        //} else {
            //	updateCondition(condition)
            }
        } else {
        	//if condition group
        	if (deleteGroups && (condition.children.size() == 0)) {
	        	deleteCondition(condition.id);
	            return true
	        }
        }
    }
    updateCondition(condition)
    return result
}

private getConditionDescription(id, level = 0) {
	def condition = getCondition(id)
    def pre = ""
    def preNot = ""
    def tab = ""
    def aft = ""
    def conditionGroup = (condition.children != null)
    switch (level) {
    	case 1:
        	pre = " ┌ ("
        	preNot = " ┌ NOT ("
        	tab = " │   "
        	aft = " └ )"
	        break;
        case 2:
    	    pre = " │ ┌ ["
    	    preNot = " │ ┌ NOT ["
        	tab = " │ │   "
       		aft = " │ └ ]"
        	break;
        case 3:
	        pre = " │ │ ┌ <"
	        preNot = " │ │ ┌ NOT {"
        	tab = " │ │ │   "
    	    aft = " │ │ └ >"
        	break;
    }
    if (!conditionGroup) {
    	//single condition
        if (condition.attr == "time") {
        	return getTimeConditionDescription(condition)
        }
        def capability = getCapabilityByDisplay(condition.cap)
        def virtualDevice = capability ? capability.virtualDevice : null
		def devices = virtualDevice ? null : settings["condDevices$id"]
        if (virtualDevice || (devices && devices.size())) {
            def evaluation = (virtualDevice ? "" : (devices.size() > 1 ? (condition.mode == "All" ? "Each of " : "Any of ") : ""))
            def deviceList = (virtualDevice ? (capability.virtualDeviceName ? capability.virtualDeviceName : virtualDevice.name) : buildDeviceNameList(devices, "or")) + " "
	        def attribute = condition.attr + " "
            def attr = getAttributeByName(condition.attr)
            def unit = (attr && attr.unit ? attr.unit : "")
            def comparison = cleanUpComparison(condition.comp)
            def comp = getComparisonOption(condition.attr, comparison)
            def values = " [ERROR]"
            def time = ""
            if (comp) {
            	switch (comp.parameters) {
                	case 0:
                    	values = ""
                        break
                    case 1:
                    	def o1 = condition.o1 ? (condition.o1 < 0 ? " - " : " + ") + condition.o1.abs() : ""
                    	values = " ${(condition.var1 ? "{" + condition.var1 + o1 + "}$unit" : (condition.dev1 ? "{[" + condition.dev1 + "]" + o1 + "}$unit" : condition.val1 + unit))}"
                        break
                    case 2:
                    	def o1 = condition.o1 ? (condition.o1 < 0 ? " - " : " + ") + condition.o1.abs() : ""
                    	def o2 = condition.o2 ? (condition.o2 < 0 ? " - " : " + ") + condition.o2.abs() : ""
                    	values = " ${(condition.var1 ? "{" + condition.var1 + o1 + "}$unit" : (condition.dev1 ? "{[" + condition.dev1 + "]" + o1 + "}$unit" : condition.val1 + unit)) + " - " + (condition.var2 ? "{" + condition.var2 + o2 + "}$unit" : (condition.dev2 ? "{[" + condition.dev2 + "]" + o2 + "}$unit" : condition.val2 + unit))}"
                        break                       
            	}
                if (comp.timed) {
                	if (condition.for && condition.fort) {
                		time = " " + condition.for + " " + condition.fort
                    } else {
                    	time = " for [ERROR]"
                    }
                }
            }
            if (virtualDevice) {
            	attribute = ""
            }
            return tab + (condition.trg ? triggerPrefix() : conditionPrefix()) + evaluation + deviceList + attribute + comparison + values + time
        }
        return "Sorry, incomplete rule"
	} else {
    	//condition group
        def grouping = settings["condGrouping$id"]
        def negate = settings["condNegate$id"]
        def result = (negate ? preNot : pre) + "\n"
        def cnt = 1
        for (child in condition.children) {
        	result += getConditionDescription(child.id, level + (child.children == null ? 0 : 1)) + "\n" + (cnt < condition.children.size() ? tab + grouping + "\n" : "")
            cnt++
        }
        result += aft
        return result
    }
}


private getTimeConditionDescription(condition) {
	if (condition.attr != "time") {
    	return "[ERROR]"
    }
    def attr = getAttributeByName(condition.attr)
    def comparison = cleanUpComparison(condition.comp)
    def comp = getComparisonOption(condition.attr, comparison)
    def result = (condition.trg ? "Trigger " : "Time ") + comparison
    def val1 = condition.val1 ? condition.val1 : ""
    def val2 = condition.val2 ? condition.val2 : ""
    if (attr && comp) {
    	//is the condition a trigger?
    	def trigger = (comp.trigger == comparison)
        def repeating = trigger
        
    	for (def i = 1; i <= comp.parameters; i++) {
        	def val = (i == 1 ? val1 : val2)
            def recurring = false
            def preciseTime = false
            if (val.contains("custom")) {
                //custom time
                val = formatTime(i == 1 ? condition.t1 : condition.t2)
                preciseTime = true
                //def hour = condition.t1.getHour()
                //def minute = condition.t2.getMinute()
            } else if (val.contains("every")) {
            	recurring = true
                repeating = false
                //take out the "happens at" and replace it with "happens "... every [something]
                result = result.replace("happens at", "happens")
            	if (val.contains("number")) {
                	//multiple minutes or hours
                	val = "every ${condition.e} ${val.contains("minute") ? "minutes" : "hours"}"
                } else {
                	//one minute or one hour
                    //no change to val
				}
            } else {
                //simple, no change to val
            }
            
            if (comparison.contains("around")) {
            	def range = i == 1 ? condition.o1 : condition.o2
            	val += " ± $range minute${range > 1 ? "s" : ""}"
            } else {
            	if ((!preciseTime) && (!recurring)) {
	            	def offset = i == 1 ? condition.o1 : condition.o2
                    if (offset == null) { 
                    	offset = 0
                    }
                    def after = offset >= 0
                    offset = offset.abs()
                    if (offset != 0) {
                        result = result.replace("happens at", "happens")
                        val = "${offset} minute${offset > 1 ? "s" : ""} ${after ? "after" : "before"} $val"
                    }
                }
            }
            
            if (i == 1) {
            	val1 = val
           	} else {
            	val2 = val
            }
            
		}
        
        switch (comp.parameters) {
        	case 1:
            	result += " $val1"
                break
            case 2:
            	result += " $val1 and $val2"
                break
        }
        
        //repeat options
        if (repeating) {
            def repeat = condition.r
            if (repeat) {
            	if (repeat.contains("day")) {
                	//every day
                    //every N days
                	if (repeat.contains("number")) {
	                    result += ", ${repeat.replace("number of ", condition.re > 2 ? "${condition.re} " : (condition.re == 2 ? "other " : "")).replace("days", condition.re > 2 ? "days" : "day")}"
	                } else {
	                    result += ", $repeat"
	                }
				}
            	if (repeat.contains("week")) {
                	//every day
                    //every N days
                    def dow = condition.rdw ? condition.rdw : "[ERROR]"
                	if (repeat.contains("number")) {
	                    result += ", ${repeat.replace("number of ", condition.re > 2 ? "${condition.re} " : (condition.re == 2 ? "other " : "")).replace("weeks", condition.re > 2 ? "weeks" : "week").replace("week", "${dow}")}"
	                } else {
	                    result += ", every $dow"
	                }
				}
                if (repeat.contains("month")) {
                	//every Nth of the month
                    //every Nth of every N months
                    //every first/second/last [dayofweek] of the month
                    //every first/second/last [dayofweek] of every N months
                	if (repeat.contains("number")) {
	                    result += ", " + formatDayOfMonth(condition.rd, condition.rdw) + " of ${repeat.replace("number of ", condition.re > 2 ? "${condition.re} " : (condition.re == 2 ? "other " : "")).replace("months", condition.re > 2 ? "months" : "month")}"
	                } else {
	                    result += ", " + formatDayOfMonth(condition.rd, condition.rdw).replace("the", "every")
	                }
                }
                if (repeat.contains("year")) {
                	//oh boy, we got years too!
                    def month = condition.rm ? condition.rm : "[ERROR]"
                	if (repeat.contains("number")) {                    
	                    result += ", " + formatDayOfMonth(condition.rd, condition.rdw) + " of ${month} of ${repeat.replace("number of ", condition.re > 2 ? "${condition.re} " : (condition.re == 2 ? "other " : "")).replace("years", condition.re > 2 ? "years" : "year")}"
	                } else {
	                    result += ", " + formatDayOfMonth(condition.rd, condition.rdw).replace("the", "every") + " of ${month}"
	                }                    
                }
            } else {
                result += " [REPEAT INCOMPLETE]"
            }
        }
        
        //filters
		if (condition.fmh || condition.fhd || condition.fdw || condition.fdm || condition.fwm || condition.fmy || condition.fy) {
        	//we have some filters
            /*
                condition.fmh = settings["condMOH${condition.id}"]
                condition.fhd = settings["condHOD${condition.id}"]
                condition.fdw = settings["condDOW${condition.id}"]
                condition.fdm = settings["condDOM${condition.id}"]
                condition.fmy = settings["condMOY${condition.id}"]
                condition.fy = settings["condY${condition.id}"]
			*/
            result += ", but only if"
            def i = 0
            if (condition.fmh) {
            	result += "${i > 0 ? ", and" : ""} the minute is ${buildNameList(condition.fmh, "or")}"
                i++
            }
            if (condition.fhd) {
            	result += "${i > 0 ? ", and" : ""} the hour is ${buildNameList(condition.fhd, "or")}"
                i++
            }
            if (condition.fdw) {
            	result += "${i > 0 ? ", and" : ""} the day of the week is ${buildNameList(condition.fdw, "or")}"
                i++
            }
            if (condition.fwm) {
            	result += "${i > 0 ? ", and" : ""} the week is ${buildNameList(condition.fwm, "or")} of the month"
                i++
            }
            if (condition.fdm) {
            	result += "${i > 0 ? ", and" : ""} the day is ${buildNameList(condition.fdm, "or")} of the month"
                i++
            }
            if (condition.fmy) {
            	result += "${i > 0 ? ", and" : ""} the month is ${buildNameList(condition.fmy, "or")}"
                i++
            }
            if (condition.fy) {
            	def odd = "odd years" in condition.fy
            	def even = "even years" in condition.fy
               	def leap = "leap years" in condition.fy
                def list = []
                //if we have both odd and even selected, that would match all years, so get out                
                if (!(even && odd)) {
                    if (odd || even || leap) {   
                        if (odd) list.push("odd")
                        if (even) list.push("even")
                        if (leap) list.push("leap")
                    }
				}
                for(year in condition.fy) {
                	if (!year.contains("year")) {
                    	list.push(year)
                    }
                }
                if (list.size()) {
                	result += "${i > 0 ? ", and" : ""} the year is ${buildNameList(list, "or")}"
                }
            }
            
        }
        
        
    }
	return result
}





/******************************************************************************/
/*** ACTION FUNCTIONS														***/
/******************************************************************************/

def getAction(actionId) {
    def parent = (state.run == "config" ? state.config : state)
	for(action in parent.app.actions) {
    	if (action.id == actionId) {
        	return action
        }
    }
    return null
}
def listActions(conditionId, whileDo = false) {
	def result = []
    def parent = (state.run == "config" ? state.config : state)

	for(action in parent.app.actions) {
    	if ((action.pid == conditionId) && (action.w == whileDo)) {
        	result.push(action)
        }
    }
    
    return result
}



/******************************************************************************/
/*** OTHER FUNCTIONS														***/
/******************************************************************************/

private sanitizeVariableName(name) {
	name = name ? name.trim().replace(" ", "_") : null
}

def dummy() {
	//evaluates a condition
    def perf = now()
	debug "Entering dummy()", 1
    //using this for development
   
//    scheduleTimeTriggers()
    
//    publishTasks()
    
    perf = now() - perf
    debug "Exiting dummy() after ${perf}ms", -1

}

private cleanUpMap(map) {
	def dirty = true
    while (dirty) {
    	dirty = false
        //we need to break the loop every time we removed an item
        for(item in map) {
        	if (item.value == null) {
            	map.remove(item.key)
                dirty = true
                break
            }
        }
    }
	return map
}

private cleanUpAttribute(attribute) {
	if (attribute) {
		return attribute.replace(customAttributePrefix(), "")
    }
    return null
}

private cleanUpCommand(command) {
	if (command) {
		return command.replace(customCommandPrefix(), "").replace(virtualCommandPrefix(), "").replace(customCommandSuffix(), "")
    }
    return null
}

private cleanUpComparison(comparison) {
	if (comparison) {
		return comparison.replace(triggerPrefix(), "").replace(conditionPrefix(), "")
    }
    return null
}

private buildDeviceNameList(devices, suffix) {
	def cnt = 1
    def result = ""
	for (device in devices) {
        result += device?.label + (cnt < devices.size() ? (cnt == devices.size() - 1 ? " $suffix " : ", ") : "")
        cnt++
    }
    return result;
}

private buildNameList(list, suffix) {
	def cnt = 1
    def result = ""
	for (item in list) {
        result += item + (cnt < list.size() ? (cnt == list.size() - 1 ? "${list.size() > 2 ? "," : ""} $suffix " : ", ") : "")
        cnt++
    }
    return result;
}











/******************************************************************************/
/*** DATABASE FUNCTIONS														***/
/******************************************************************************/
//returns a list of all available capabilities
private listCapabilities(requireAttributes, requireCommands) {
    def result = []
    for (capability in capabilities()) {
    	if ((requireAttributes && capability.attribute) || (requireCommands && capability.commands) || !(requireAttributes || requireCommands)) {
	    	result.push(capability.display)
		}
    }
    return result
}

//returns a list of all available attributes
private listAttributes() {
    def result = []
    for (attribute in attributes()) {
    	result.push(attribute.name)
    }
    return result.sort()
}

//returns a list of possible comparison options for a selected attribute
private listComparisonOptions(attributeName, allowTriggers) {
    def conditions = []
    def triggers = []
    def attribute = getAttributeByName(attributeName)
    if (attribute) {
    	def optionCount = attribute.options ? attribute.options.size() : 0
        def attributeType = attribute.type
        for (comparison in comparisons()) {
            if (comparison.type == attributeType) {
                for (option in comparison.options) {
                    if (option.condition && (!option.minOptions || option.minOptions <= optionCount)) {
                        conditions.push(conditionPrefix() + option.condition)
                    }
                    if (allowTriggers && option.trigger && (!option.minOptions || option.minOptions <= optionCount)) {
                        triggers.push(triggerPrefix() + option.trigger)
                    }
                }
            }
        }
    }
    return conditions.sort() + triggers.sort()
}

//returns the comparison option object for the given attribute and selected comparison
private getComparisonOption(attributeName, comparisonOption) {	
    def attribute = getAttributeByName(attributeName)
    if (attribute && comparisonOption) {
		def attributeType = attribute.type
        for (comparison in comparisons()) {
            if (comparison.type == attributeType) {
                for (option in comparison.options) {
                    if (option.condition == comparisonOption) {
                        return option
                    }
                    if (option.trigger == comparisonOption) {
                    	return option
                    }
                }
            }
        }
    }
    return null	
}

//returns true if the comparisonOption selected for the given attribute is a trigger-type condition
private isComparisonOptionTrigger(attributeName, comparisonOption) {
    def attribute = getAttributeByName(attributeName)
    if (attribute) {
		def attributeType = attribute.type
        for (comparison in comparisons()) {
            if (comparison.type == attributeType) {
                for (option in comparison.options) {
                    if (option.condition == comparisonOption) {
                        return false
                    }
                    if (option.trigger == comparisonOption) {
                    	return true
                    }
                }
            }
        }
    }
    return false	
}

//returns the list of attributes that exist for all devices in the provided list
private listCommonDeviceAttributes(devices) {
	def list = [:]
    def customList = [:]
    //build the list of standard attributes
	for (attribute in attributes()) {
    	list[attribute.name] = 0
    }
	//get supported attributes
    for (device in devices) {
    	def attrs = device.supportedAttributes
        for (attr in attrs) {        	
        	if (list.containsKey(attr.name)) {
            	//if attribute exists in standard list, increment its usage count
	       		list[attr.name] = list[attr.name] + 1
            } else {
            	//otherwise increment the usage count in the custom list
	       		customList[attr.name] = customList[attr.name] ? customList[attr.name] + 1 : 1
            }
        }
    }
    def result = []
    //get all common attributes from the standard list
    for (item in list) {
    	//ZWave Lock reports lock twice - others may do the same, so let's allow multiple instances
    	if (item.value >= devices.size()) {
        	result.push(item.key)
        }
    }
    //get all common attributes from the custom list
    for (item in customList) {
    	//ZWave Lock reports lock twice - others may do the same, so let's allow multiple instances
    	if (item.value >= devices.size()) {
        	result.push(customAttributePrefix() + item.key)
        }
    }
    //return the sorted list
    return result.sort()
}


private listCommonDeviceCommands(devices, capabilities) {
	def list = [:]
    def customList = [:]
    //build the list of standard attributes
	for (command in commands()) {
    	list[command.name] = 0
    }
	//get supported attributes
    for (device in devices) {
    	def cmds = device.supportedCommands
        for (cmd in cmds) {
        	def found = false
            for (capability in capabilities) {
            	def name = capability + "." + cmd.name
                if (list.containsKey(name)) {
                    //if attribute exists in standard list, increment its usage count
                    list[name] = list[name] + 1
                    found = true
                }
            }
        	if (!found && list.containsKey(cmd.name)) {
            	//if attribute exists in standard list, increment its usage count
	       		list[cmd.name] = list[cmd.name] + 1
                found = true
            }
            if (!found) {
            	//otherwise increment the usage count in the custom list
	       		customList[cmd.name] = customList[cmd.name] ? customList[cmd.name] + 1 : 1
            }
        }
    }
    
    def result = []
    //get all common attributes from the standard list
    for (item in list) {
    	//ZWave Lock reports lock twice - others may do the same, so let's allow multiple instances
    	if (item.value >= devices.size()) {
        	def command = getCommandByName(item.key)
            if (command && command.display) {
        		result.push(command.display)
            }
        }
    }
    //get all common attributes from the custom list
    for (item in customList) {
    	//ZWave Lock reports lock twice - others may do the same, so let's allow multiple instances
    	if (item.value >= devices.size()) {
        	result.push(customCommandPrefix() + item.key + customCommandSuffix())
        }
    }
    //return the sorted list
    return result.sort()
}

private getCapabilityByName(name) {
    for (capability in capabilities()) {
    	if (capability.name == name) {
        	return capability
        }
    }
    return null
}

private getCapabilityByDisplay(display) {
    for (capability in capabilities()) {
    	if (capability.display == display) {
        	return capability
        }
    }
    return null
}

private getAttributeByName(name) {
    for (attribute in attributes()) {
    	if (attribute.name == name) {
        	return attribute
        }
    }
    return [ name: name, type: "text", range: null, unit: null, options: null]
}

//returns all available command categories
private listCommandCategories() {
	def categories = []
	for(def command in commands()) {
    	if (command.category && !(command.category in categories)) {
        	categories.push(command.category)
        }
    }
    return categories
}

//returns all available commands in a category
private listCategoryCommands(category) {
	def result = []
    for(def command in commands()) {
    	if ((command.category == category) && !(command.name in result)) {
        	result.push(command)
        }
    }
    return result
}

//gets a category and command and returns the user friendly display name
private getCommand(category, name) {
    for(def command in commands()) {
    	if ((command.category == category) && (command.name == name)) {
        	return command
        }
    }
    return null
}

private getCommandByName(name) {
    for(def command in commands()) {
    	if (command.name == name) {
        	return command
        }
    }
    return null
}

private getVirtualCommandByName(name) {
    for(def command in virtualCommands()) {
    	if (command.name == name) {
        	return command
        }
    }
    return null
}

private getCommandByDisplay(display) {
    for(def command in commands()) {
    	if (command.display == display) {
        	return command
        }
    }
    return null
}

private getVirtualCommandByDisplay(display) {
    for(def command in virtualCommands()) {
    	if (command.display == display) {
        	return command
        }
    }
    return null
}

//gets a category and command and returns the user friendly display name
private getCommandGroupName(category, name) {
    def command = getCommand(category, name)
    return getCommandGroupName(command)
}

private getCommandGroupName(command) {
	if (!command) {
    	return null
    }
    if (!command.group) {
    	return null
    }
    if (command.group.contains("[devices]")) {
        def list = []
        for (capability in listCommandCapabilities(command)) {
        	if ((capability.devices) && !(capability.devices in list)){
            	list.push(capability.devices)
            }
        }
        return command.group.replace("[devices]", buildNameList(list, "or"))
	} else {
    	return command.group
    }
}


//gets a category and command and returns the user friendly display name
private listCommandCapabilities(command) {
	//first off, find all commands that are capability-custom (i.e. name is of format <capability>.<name>)
    //we need to exclude these capabilities
    //if our name is of form <capability>.<name>
    if (command.name.contains(".")) {
    	//easy, we only have one capability
        def cap = getCapabilityByName(command.name.tokenize(".")[0])
        if (!cap) {
        	return []
        }
        return [cap]
    }
    def excludeList = []
    for(def c in commands()) {
    	if (c.name.endsWith(".${command.name}")) {
        	//get the capability and add it to an exclude list
        	excludeList.push(c.name.tokenize(".")[0])
        }
    }
    //now get the capability names
    def result = []
    for(def c in capabilities()) {
    	if (!(c.name in excludeList) && c.commands && (command.name in c.commands)) {
        	result.push(c)
        }
    }
    return result
}

private parseCommandParameter(parameter) {
	if (!parameter) {
    	return null
    }
    
    def required = !(parameter && parameter.startsWith("?"))
    if (!required) {
    	parameter = parameter.substring(1)
    }

    def last = (parameter && parameter.startsWith("*"))
    if (last) {
    	parameter = parameter.substring(1)
    }

    //split by :
	def tokens = parameter.tokenize(":")
    if (tokens.size() < 2) {
    	return [title: tokens[0], type: "text", required: required, last: last]
    }
    def title = ""
    def dataType = ""
    if (tokens.size() == 2) {
    	title = tokens[0]
        dataType = tokens[1]
	} else {
    	//title contains at least one :, so we rebuild it
    	for(def i=0; i < tokens.size() - 1; i++) {
        	title += (title ? ":" : "") + tokens[i]
        }
        dataType = tokens[tokens.size() - 1]
    }

    if (dataType in ["attribute", "attributes", "variable", "variables"]) {
    	//special case handled internally
        return [title: title, type: dataType, required: required, last: last]
    }
    
  
    //at this point, let's check if we're dealing with a custom data type
    //we accept
    // string
    // text
    // number
    // number[range]
    // decimal
    // decimal[range]
    // enum[comma separated list, double quotes not required]
    
    tokens = dataType.tokenize("[]")
    if (tokens.size()) {
    	dataType = tokens[0]
        switch (tokens.size()) {
            case 1:
            	switch (dataType) {
                	case "string":
                	case "text":
                    	return [title: title, type: "text", required: required, last: last]
                	case "number":
                	case "decimal":
                    	return [title: title, type: dataType, required: required, last: last]
                }
                break
            case 2:
            	switch (dataType) {
                	case "string":
                	case "text":
                    	return [title: title, type: "text", required: required, last: last]
                	case "number":
                	case "decimal":
                    	return [title: title, type: dataType, range: tokens[1], required: required, last: last]
                	case "enum":
                    	return [title: title, type: dataType, options: tokens[1].tokenize(","), required: required, last: last]
                }
                break
        }
	}
    
    //check to see if dataType is an attribute, we use the attribute declaration then
    def attr = getAttributeByName(dataType)
    if (attr) {
    	return [title: title + (attr.unit ? " (${attr.unit})" : ""), type: attr.type, range: attr.range, options: attr.options, required: required, last: last]
    }
    
    //give up
    return null
}






/******************************************************************************/
/*** DATABASE																***/
/******************************************************************************/

private capabilities() {
	return [
    	[ name: "accelerationSensor",				display: "Acceleration Sensor",				attribute: "acceleration",				commands: null,																		multiple: true,			],
    	[ name: "alarm",							display: "Alarm",							attribute: "alarm",						commands: ["off", "strobe", "siren", "both"],										multiple: true,			devices: "sirens",			],
    	[ name: "doorControl",						display: "Automatic Door",					attribute: "door",						commands: ["open", "close"],														multiple: true,			devices: "doors",			],
    	[ name: "garageDoorControl",				display: "Automatic Garage Door",			attribute: "door",						commands: ["open", "close"],														multiple: true,			devices: "garage doors",		],
        [ name: "battery",							display: "Battery",							attribute: "battery",					commands: null,																		multiple: true,			],
    	[ name: "beacon",							display: "Beacon",							attribute: "presence",					commands: null,																		multiple: true,			],
        [ name: "button",							display: "Button",							attribute: "button",					commands: null,																		multiple: true,			],
        [ name: "imageCapture",						display: "Camera",							attribute: "image",						commands: ["take"],																	multiple: true,			devices: "cameras",			],
    	[ name: "carbonDioxideMeasurement",			display: "Carbon Dioxide Measurement",		attribute: "carbonDioxide",				commands: null,																		multiple: true,			],
        [ name: "carbonMonoxideDetector",			display: "Carbon Monoxide Detector",		attribute: "carbonMonoxide",			commands: null,																		multiple: true,			],
    	[ name: "colorControl",						display: "Color Control",					attribute: "color",						commands: ["setColor", "setHue", "setSaturation"],									multiple: true,			devices: "RGB/W lights"		],
        [ name: "colorTemperature",					display: "Color Temperature",				attribute: "colorTemperature",			commands: ["setColorTemperature"],													multiple: true,			devices: "RGB/W lights"],
    	[ name: "configure",						display: "Configure",						attribute: null,						commands: ["configure"],															multiple: true,			],
    	[ name: "consumable",						display: "Consumable",						attribute: "consumable",				commands: ["setConsumableStatus"],													multiple: true,			],
		[ name: "contactSensor",					display: "Contact Sensor",					attribute: "contact",					commands: null,																		multiple: true,			],
    	[ name: "dateAndTime",						display: "Date & Time",						attribute: "time",						commands: null, /* wish we could control time */									multiple: true,			, virtualDevice: [id: "dt"],		virtualDeviceName: "Date & Time"	],
    	[ name: "switchLevel",						display: "Dimmable Light",					attribute: "level",						commands: ["setLevel"],																multiple: true,			devices: "dimmable lights",	],
    	[ name: "switchLevel",						display: "Dimmer",							attribute: "level",						commands: ["setLevel"],																multiple: true,			devices: "dimmers",			],
    	[ name: "energyMeter",						display: "Energy Meter",					attribute: "energy",					commands: null,																		multiple: true,			],
        [ name: "illuminanceMeasurement",			display: "Illuminance Measurement",			attribute: "illuminance",				commands: null,																		multiple: true,			],
        [ name: "imageCapture",						display: "Image Capture",					attribute: "image",						commands: ["take"],																	multiple: true,			],
    	[ name: "waterSensor",						display: "Leak Sensor",						attribute: "water",						commands: null,																		multiple: true,			],
    	[ name: "switch",							display: "Light",							attribute: "switch",					commands: ["on", "off"],															multiple: true,			devices: "lights", 			],
        [ name: "locationMode",						display: "Location Mode",					attribute: "mode",						commands: ["setMode"],																multiple: false,		, virtualDevice: location	],
        [ name: "lock",								display: "Lock",							attribute: "lock",						commands: ["lock", "unlock"],														multiple: true,			devices: "electronic locks", ],
    	[ name: "mediaController",					display: "Media Controller",				attribute: "currentActivity",			commands: ["startActivity", "getAllActivities", "getCurrentActivity"],				multiple: true,			],
    	[ name: "momentary",						display: "Momentary",						attribute: null,						commands: ["push"],																	multiple: true,			],
    	[ name: "motionSensor",						display: "Motion Sensor",					attribute: "motion",					commands: null,																		multiple: true,			],
    	[ name: "musicPlayer",						display: "Music Player",					attribute: "status",					commands: ["play", "pause", "stop", "nextTrack", "playTrack", "setLevel", "playText", "mute", "previousTrack", "unmute", "setTrack", "resumeTrack", "restoreTrack"],	multiple: true,			devices: "music players", ],
    	[ name: "notification",						display: "Notification",					attribute: null,						commands: ["deviceNotification"],													multiple: true,			],
    	[ name: "pHMeasurement",					display: "pH Measurement",					attribute: "pH",						commands: null,																		multiple: true,			],
    	[ name: "polling",							display: "Polling",							attribute: null,						commands: ["poll"],																	multiple: true,			],
        [ name: "powerMeter",						display: "Power Meter",						attribute: "power",						commands: null,																		multiple: true,			],
        [ name: "powerSource",						display: "Power Source",					attribute: "powerSource",				commands: null,																		multiple: true,			],
    	[ name: "presenceSensor",					display: "Presence Sensor",					attribute: "presence",					commands: null,																		multiple: true,			],
    	[ name: "refresh",							display: "Refresh",							attribute: null,						commands: ["refresh"],																multiple: true,			],
    	[ name: "relativeHumidityMeasurement",		display: "Relative Humidity Measurement",	attribute: "humidity",					commands: null,																		multiple: true,			],
    	[ name: "relaySwitch",						display: "Relay Switch",					attribute: "switch",					commands: ["on", "off"],															multiple: true,			devices: "outlets",			],
    	[ name: "shockSensor",						display: "Shock Sensor",					attribute: "shock",						commands: null,																		multiple: true,			],
    	[ name: "signalStrength",					display: "Signal Strength",					attribute: "lqi",						commands: null,																		multiple: true,			],
    	[ name: "alarm",							display: "Siren",							attribute: "alarm",						commands: ["off", "strobe", "siren", "both"],										multiple: true,			devices: "sirens",			],
    	[ name: "sleepSensor",						display: "Sleep Sensor",					attribute: "sleeping",					commands: null,																		multiple: true,			],
    	[ name: "smartHomeMonitor",					display: "Smart Home Monitor",				attribute: "alarmSystemStatus",			commands: null,																		multiple: true,			, virtualDevice: location,	virtualDeviceName: "Smart Home Monitor"	],
    	[ name: "smokeDetector",					display: "Smoke Detector",					attribute: "smoke",						commands: null,																		multiple: true,			],
        [ name: "soundSensor",						display: "Sound Sensor",					attribute: "sound",						commands: null,																		multiple: true,			],
    	[ name: "speechSynthesis",					display: "Speech Synthesis",				attribute: null,						commands: ["speak"],																multiple: true,			devices: "speech synthesizers", ],
        [ name: "stepSensor",						display: "Step Sensor",						attribute: "steps",						commands: null,																		multiple: true,			],
    	[ name: "switch",							display: "Switch",							attribute: "switch",					commands: ["on", "off"],															multiple: true,			devices: "switches",			],
    	[ name: "switchLevel",						display: "Switch Level",					attribute: "level",						commands: ["setLevel"],																multiple: true,			devices: "dimmers" ],
        [ name: "soundPressureLevel",				display: "Sound Pressure Level",			attribute: "soundPressureLevel",		commands: null,																		multiple: true,			],
    	[ name: "consumable",						display: "Stock Management",				attribute: "consumable",				commands: null,																		multiple: true,			],
    	[ name: "tamperAlert",						display: "Tamper Alert",					attribute: "tamper",					commands: null,																		multiple: true,			],
    	[ name: "temperatureMeasurement",			display: "Temperature Measurement",			attribute: "temperature",				commands: null,																		multiple: true,			],
        [ name: "thermostat",						display: "Thermostat",						attribute: "temperature",				commands: ["setHeatingSetpoint", "setCoolingSetpoint", "off", "heat", "emergencyHeat", "cool", "setThermostatMode", "fanOn", "fanAuto", "fanCirculate", "setThermostatFanMode", "auto"],	multiple: true,		devices: "thermostats"	],
        [ name: "thermostatCoolingSetpoint",		display: "Thermostat Cooling Setpoint",		attribute: "coolingSetpoint",			commands: ["setCoolingSetpoint"],													multiple: true,			],
    	[ name: "thermostatFanMode",				display: "Thermostat Fan Mode",				attribute: "thermostatFanMode",			commands: ["fanOn", "fanAuto", "fanCirculate", "setThermostatFanMode"],				multiple: true,			devices: "fans",	],
    	[ name: "thermostatHeatingSetpoint",		display: "Thermostat Heating Setpoint",		attribute: "heatingSetpoint",			commands: ["setHeatingSetpoint"],													multiple: true,			],
    	[ name: "thermostatMode",					display: "Thermostat Mode",					attribute: "thermostatMode",			commands: ["off", "heat", "emergencyHeat", "cool", "auto", "setThermostatMode"],	multiple: true,			],
    	[ name: "thermostatOperatingState",			display: "Thermostat Operating State",		attribute: "thermostatOperatingState",	commands: null,																		multiple: true,			],
    	[ name: "thermostatSetpoint",				display: "Thermostat Setpoint",				attribute: "thermostatSetpoint",		commands: null,																		multiple: true,			],
    	[ name: "threeAxis",						display: "Three Axis Sensor",				attribute: "threeAxis",					commands: null,																		multiple: true,			],
    	[ name: "timedSession",						display: "Timed Session",					attribute: "sessionStatus",				commands: ["setTimeRemaining", "start", "stop", "pause", "cancel"],					multiple: true,			],
    	[ name: "tone",								display: "Tone Generator",					attribute: null,						commands: ["tone"],																	multiple: true,			devices: "tone generators",	],
    	[ name: "touchSensor",						display: "Touch Sensor",					attribute: "touch",						commands: null,																		multiple: true,			],
    	[ name: "valve",							display: "Valve",							attribute: "contact",					commands: ["open", "close"],														multiple: true,			devices: "valves",			],
    	[ name: "voltageMeasurement",				display: "Voltage Measurement",				attribute: "voltage",					commands: null,																		multiple: true,			],
    	[ name: "waterSensor",						display: "Water Sensor",					attribute: "water",						commands: null,																		multiple: true,			],
        [ name: "windowShade",						display: "Window Shade",					attribute: "windowShade",				commands: ["open", "close", "presetPosition"],										multiple: true,			devices: "window shades",	],
    ]
}

private commands() {
	return [
    	[ name: "on",							category: "Convenience",				group: "Control [devices]",			display: "Turn on", 					parameters: [], ],
    	[ name: "off",							category: "Convenience",				group: "Control [devices]",			display: "Turn off",					parameters: [], ],
    	[ name: "toggle",						category: "Convenience",				group: null,						display: "Toggle",						parameters: [], ],
    	[ name: "setLevel",						category: "Convenience",				group: "Control [devices]",			display: "Set level",					parameters: ["Level:level"], ],
    	[ name: "setColor",						category: "Convenience",				group: "Control [devices]",			display: "Set color",					parameters: ["?*Color:color","Hue:hue","Saturation:saturation","Level:level"], ],
    	[ name: "setHue",						category: "Convenience",				group: "Control [devices]",			display: "Set hue",						parameters: ["Hue:hue"], ],
    	[ name: "setSaturation",				category: "Convenience",				group: "Control [devices]",			display: "Set saturation",				parameters: ["Saturation:saturation"], ],
    	[ name: "setColorTemperature",			category: "Convenience",				group: "Control [devices]",			display: "Set color temperature",		parameters: ["Color Temperature:colorTemperature"], ],
    	[ name: "open",							category: "Convenience",				group: "Control [devices]",			display: "Open",						parameters: [], ],
    	[ name: "close",						category: "Convenience",				group: "Control [devices]",			display: "Close",						parameters: [], ],
    	[ name: "windowShade.open",				category: "Convenience",				group: "Control [devices]",			display: "Open",						parameters: [], ],
    	[ name: "windowShade.close",			category: "Convenience",				group: "Control [devices]",			display: "Close",						parameters: [], ],
    	[ name: "windowShade.presetPosition",	category: "Convenience",				group: "Control [devices]",			display: "Move to preset position",		parameters: [], ],
    	[ name: "lock",							category: "Safety and Security",		group: "Control [devices]",			display: "Lock",						parameters: [], ],
    	[ name: "unlock",						category: "Safety and Security",		group: "Control [devices]",			display: "Unlock",						parameters: [], ],
    	[ name: "alarm.off",					category: "Safety and Security",		group: "Control [devices]",			display: "Stop",						parameters: [], ],
    	[ name: "alarm.strobe",					category: "Safety and Security",		group: "Control [devices]",			display: "Strobe",						parameters: [], ],
    	[ name: "alarm.siren",					category: "Safety and Security",		group: "Control [devices]",			display: "Siren",						parameters: [], ],
    	[ name: "alarm.both",					category: "Safety and Security",		group: "Control [devices]",			display: "Strobe and Siren",			parameters: [], ],
    	[ name: "thermostat.off",				category: "Comfort",					group: "Control [devices]",			display: "Set to Off",					parameters: [], ],
    	[ name: "thermostat.heat",				category: "Comfort",					group: "Control [devices]",			display: "Set to Heat",					parameters: [], ],
    	[ name: "thermostat.cool",				category: "Comfort",					group: "Control [devices]",			display: "Set to Cool",					parameters: [], ],
    	[ name: "thermostat.auto",				category: "Comfort",					group: "Control [devices]",			display: "Set to Auto",					parameters: [], ],
    	[ name: "thermostat.emergencyHeat",		category: "Comfort",					group: "Control [devices]",			display: "Set to Emergency Heat",		parameters: [], ],
    	[ name: "thermostat.fanOn",				category: "Comfort",					group: "Control [devices]",			display: "Set fan to On",					parameters: [], ],
    	[ name: "thermostat.fanCiculate",		category: "Comfort",					group: "Control [devices]",			display: "Set fan to Circulate",					parameters: [], ],
    	[ name: "thermostat.fanAuto",			category: "Comfort",					group: "Control [devices]",			display: "Set fan to Auto",					parameters: [], ],
    	[ name: "thermostat.setThermostatFanMode",category: "Comfort",					group: "Control [devices]",			display: "Set fan mode",					parameters: ["Fan mode:thermostatFanMode"], ],
    	[ name: "thermostat.off",				category: "Comfort",					group: "Control [devices]",			display: "Set to Off",					parameters: [], ],
    	[ name: "speak",						category: "Entertainment",				group: "Control [devices]",			display: "Speak",						parameters: ["Message:string"], ],
    	[ name: "musicPlayer.setLevel",			category: "Entertainment",				group: "Control [devices]",			display: "Set volume",					parameters: ["Level:level"], ],
    	[ name: "playText",						category: "Entertainment",				group: "Control [devices]",			display: "Speak",						parameters: ["Message:string"], ],
    	[ name: "configure",					category: "Tools",						group: "Configure [devices]",		display: "Configure",					parameters: [], ],
    	[ name: "poll",							category: "Tools",						group: "Poll [devices]",			display: "Poll",						parameters: [], ],
    	[ name: "refresh",						category: "Tools",						group: "Refresh [devices]",			display: "Refresh",						parameters: [], ],
    ]
}

private virtualCommands() {
	return [
    	[ name: "wait",					requires: [],			 			display: "Wait",					parameters: ["Time (minutes):number[1..1440]"],												],
    	[ name: "waitRandom",			requires: [],			 			display: "Wait (random)",			parameters: ["At least (minutes):number[1..1440]","At most (minutes):number[1..1440]"],		],
    	[ name: "toggle",				requires: ["on", "off"], 			display: "Toggle",																												],
    	[ name: "captureAttribute",		requires: [],			 			display: "Capture attribute to variable", parameters: ["Attribute:attribute","Into variable...:string"],			singleDevice: true,	varEntry: 1],
    	[ name: "captureState",			requires: [],			 			display: "Capture state to variable",parameters: ["?Attributes:attributes","Into variable...:string"],		singleDevice: true,	varEntry: 1],
    	[ name: "captureStateLocally",	requires: [],			 			display: "Capture local state",		parameters: ["?Attributes:attributes"],														],
    	[ name: "captureStateGlobally",	requires: [],			 			display: "Capture global state",	parameters: ["?Attributes:attributes"],														],
    	[ name: "restoreAttribute",		requires: [],			 			display: "Restore attribute from variable",	parameters: ["Attribute:attribute","From variable...:variable"],								],
    	[ name: "restoreState",			requires: [],			 			display: "Restore state from variable",parameters: ["?Attributes:attributes","From variable...:variable"],							],
    	[ name: "restoreStateLocally",	requires: [],			 			display: "Restore local state",		parameters: ["?Attributes:attributes"],														],
    	[ name: "restoreStateGlobally",	requires: [],			 			display: "Restore global state",	parameters: ["?Attributes:attributes"],														],
    ]
}

private attributes() {
	def tempUnit = "°" + location.temperatureScale
	return [
    	[ name: "acceleration",				type: "enum",				range: null,			unit: null,		options: ["active", "inactive"],																			],
    	[ name: "alarm",					type: "enum",				range: null,			unit: null,		options: ["off", "strobe", "siren", "both"],																],
    	[ name: "battery",					type: "number",				range: "0..100",		unit: "%",		options: null,																								],
    	[ name: "beacon",					type: "enum",				range: null,			unit: null,		options: ["present", "not present"],																		],
        [ name: "button",					type: "enum",				range: null,			unit: null,		options: ["held", "pushed"],																				],
    	[ name: "carbonDioxide",			type: "decimal",			range: "0..*",			unit: null,		options: null,																								],
    	[ name: "carbonMonoxide",			type: "enum",				range: null,			unit: null,		options: ["clear", "detected", "tested"],																	],
    	[ name: "color",					type: "color",				range: null,			unit: "#RRGGBB",options: null,																								],
    	[ name: "hue",						type: "number",				range: "0..100",		unit: "%",		options: null,																								],
    	[ name: "saturation",				type: "number",				range: "0..100",		unit: "%",		options: null,																								],
    	[ name: "hex",						type: "hexcolor",			range: null,			unit: null,		options: null,																								],
    	[ name: "saturation",				type: "number",				range: "0..100",		unit: "%",		options: null,																								],
    	[ name: "level",					type: "number",				range: "0..100",		unit: "%",		options: null,																								],
    	[ name: "switch",					type: "enum",				range: null,			unit: null,		options: ["on", "off"],																						],
    	[ name: "colorTemperature",			type: "number",				range: "2000..7000",	unit: "°K",		options: null,																								],
    	[ name: "consumable",				type: "enum",				range: null,			unit: null,		options: ["missing", "good", "replace", "maintenance_required", "order"],									],
    	[ name: "contact",					type: "enum",				range: null,			unit: null,		options: ["open", "closed"],																				],
    	[ name: "door",						type: "enum",				range: null,			unit: null,		options: ["unknown", "closed", "open", "closing", "opening"],												],
    	[ name: "energy",					type: "decimal",			range: "0..*",			unit: "kWh",	options: null,																								],
    	[ name: "illuminance",				type: "number",				range: "0..*",			unit: "lux",	options: null,																								],
    	[ name: "image",					type: "image",				range: null,			unit: null,		options: null,																								],
    	[ name: "lock",						type: "enum",				range: null,			unit: null,		options: ["locked", "unlocked"],																			],
    	[ name: "activities",				type: "string",				range: null,			unit: null,		options: null,																								],
    	[ name: "currentActivity",			type: "string",				range: null,			unit: null,		options: null,																								],
    	[ name: "motion",					type: "enum",				range: null,			unit: null,		options: ["active", "inactive"],																			],
    	[ name: "status",					type: "string",				range: null,			unit: null,		options: null,																								],								
    	[ name: "mute",						type: "enum",				range: null,			unit: null,		options: ["muted", "unmuted"],																				],
    	[ name: "pH",						type: "decimal",			range: "0..14",			unit: null,		options: null,																								],
    	[ name: "power",					type: "decimal",			range: "0..*",			unit: "W",		options: null,																								],
    	[ name: "presence",					type: "enum",				range: null,			unit: null,		options: ["present", "not present"],																		],
    	[ name: "humidity",					type: "number",				range: "0..100",		unit: "%",		options: null,																								],
        [ name: "shock",					type: "enum",				range: null,			unit: null,		options: ["detected", "clear"],																				],
    	[ name: "lqi",						type: "number",				range: "0..255",		unit: null,		options: null,																								],
    	[ name: "rssi",						type: "number",				range: "0..100",		unit: "%",		options: null,																								],
    	[ name: "sleeping",					type: "enum",				range: null,			unit: null,		options: ["sleeping", "not sleeping"],																		],
    	[ name: "smoke",					type: "enum",				range: null,			unit: null,		options: ["clear", "detected", "tested"],																	],
    	[ name: "sound",					type: "enum",				range: null,			unit: null,		options: ["detected", "not detected"],																		],
        [ name: "steps",					type: "number",				range: "0..*",			unit: null,		options: null,																								],
    	[ name: "goal",						type: "number",				range: "0..*",			unit: null,		options: null,																								],
    	[ name: "soundPressureLevel",		type: "number",				range: "0..*",			unit: null,		options: null,																								],
    	[ name: "tamper",					type: "enum",				range: null,			unit: null,		options: ["clear", "detected"],																				],
    	[ name: "temperature",				type: "decimal",			range: "*..*",			unit: tempUnit,	options: null,																								],
    	[ name: "thermostatMode",			type: "enum",				range: null,			unit: null,		options: ["off", "auto", "cool", "heat", "emergency heat"],													],
    	[ name: "thermostatFanMode",		type: "enum",				range: null,			unit: null,		options: ["auto", "on", "circulate"],																		],
    	[ name: "thermostatOperatingState",	type: "enum",				range: null,			unit: null,		options: ["idle", "pending cool", "cooling", "pending heat", "heating", "fan only", "vent economizer"],		],
        [ name: "coolingSetpoint",			type: "decimal",			range: "-127..127",		unit: tempUnit,	options: null,																								],
        [ name: "heatingSetpoint",			type: "decimal",			range: "-127..127",		unit: tempUnit,	options: null,																								],
        [ name: "thermostatSetpoint",		type: "decimal",			range: "-127..127",		unit: tempUnit,	options: null,																								],
        [ name: "sessionStatus",			type: "enum",				range: null,			unit: null,		options: ["paused", "stopped", "running", "canceled"],														],
    	[ name: "threeAxis",				type: "threeAxis",			range: "0..1024",		unit: null,		options: null,																								],
    	[ name: "touch",					type: "enum",				range: null,			unit: null,		options: ["touched"],																						],
    	[ name: "valve",					type: "enum",				range: null,			unit: null,		options: ["open", "closed"],																				],
        [ name: "voltage",					type: "decimal",			range: "*..*",			unit: "V",		options: null,																								],
    	[ name: "water",					type: "enum",				range: null,			unit: null,		options: ["dry", "wet"],																					],
    	[ name: "windowShade",				type: "enum",				range: null,			unit: null,		options: ["unknown", "open", "closed", "opening", "closing", "partially open"],								],
    	[ name: "mode",						type: "mode",				range: null,			unit: null,		options: location.modes,																					],
    	[ name: "alarmSystemStatus",		type: "enum",				range: null,			unit: null,		options: ["Disarmed", "Armed/Stay", "Armed/Away"],															],
    	[ name: "time",						type: "time",				range: null,			unit: null,		options: null,																								],
    ]
}

private comparisons() {
	def optionsEnum = [
        [ condition: "is", trigger: "changes to", parameters: 1, timed: false],
        [ condition: "is not", trigger: "changes away from", parameters: 1, timed: false],
        [ condition: "is one of", trigger: "changes to one of", parameters: 1, timed: false, multiple: true, minOptions: 3],
        [ condition: "was", trigger: "stays", parameters: 1, timed: true],
        [ condition: "was not", parameters: 1, timed: true],
        [ trigger: "changes", parameters: 0, timed: false],
    ]
    def optionsNumber = [
        [ condition: "is equal to", trigger: "changes to", parameters: 1, timed: false],
        [ condition: "is not equal to", trigger: "changes away from", parameters: 1, timed: false],
        [ condition: "is less than", trigger: "drops below", parameters: 1, timed: false],
        [ condition: "is less than or equal to", trigger: "drops to or below", parameters: 1, timed: false],
        [ condition: "is greater than", trigger: "raises above", parameters: 1, timed: false],
        [ condition: "is greater than or equal to", trigger: "raises to or above", parameters: 1, timed: false],
        [ condition: "is inside range", trigger: "enters range", parameters: 2, timed: false],
        [ condition: "is outside of range", trigger: "exits range", parameters: 2, timed: false],
        [ condition: "is even", trigger: "changes to an even value", parameters: 0, timed: false],
        [ condition: "is odd", trigger: "changes to an odd value", parameters: 0, timed: false],
        [ condition: "was equal to", trigger: "stays equal to", parameters: 1, timed: true],
        [ condition: "was not equal to", trigger: "stays not equal to", parameters: 1, timed: true],
        [ condition: "was less than", trigger: "stays less than", parameters: 1, timed: true],
        [ condition: "was less than or equal to", trigger: "stays less than or equal to", parameters: 1, timed: true],
        [ condition: "was greater than", trigger: "stays greater than", parameters: 1, timed: true],
        [ condition: "was greater than or equal to", trigger: "stays greater than or equal to", parameters: 1, timed: true],
        [ condition: "was inside range",trigger: "stays inside range",  parameters: 2, timed: true],
        [ condition: "was outside range", trigger: "stays outside range", parameters: 2, timed: true],
        [ condition: "was even", trigger: "stays even", parameters: 0, timed: true],
        [ condition: "was odd", trigger: "stays odd", parameters: 0, timed: true],
        [ trigger: "changes", parameters: 0, timed: false],
    ]
    def optionsTime = [
        [ trigger: "happens at", parameters: 1],
        [ condition: "is any time of day", parameters: 0],
        [ condition: "is around", parameters: 1],
        [ condition: "is before", parameters: 1],
        [ condition: "is after", parameters: 1],
        [ condition: "is between", parameters: 2],
        [ condition: "is not between", parameters: 2],
	]
	return [
    	[ type: "string",				options: optionsEnum,	],
    	[ type: "enum",					options: optionsEnum,	],
    	[ type: "mode",					options: optionsEnum,	],
    	[ type: "alarmSystemStatus",	options: optionsEnum,	],
    	[ type: "number",				options: optionsNumber,	],
    	[ type: "decimal",				options: optionsNumber	],
    	[ type: "time",					options: optionsTime,	],        
    ]
}













/******************************************************************************/
/*** DEVELOPMENT AREA														***/
/*** Write code here and then move it to its proper location				***/
/******************************************************************************/

private dev() {
}