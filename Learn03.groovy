import groovy.json.JsonSlurper
import groovy.json.JsonOutput

// Read the content of the JSON file as a string
def jsonfile = new File('todo.json')
def jsoncontent = jsonfile.text

// Print the class of the content to verify it's a string
println jsoncontent.getClass()  // Should print java.lang.String

// Parse the JSON content
def jsonSlurper = new JsonSlurper()
def jsondata = jsonSlurper.parseText(jsoncontent)  // Pass the text content, not the file

// Optionally, you can print the parsed JSON object
// println jsondata
jsondata.each {key->
// println "${key}"
key.each{val, test ->
println "${val} : ${test}"
}
}