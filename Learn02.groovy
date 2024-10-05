import groovy.json.JsonSlurper
import groovy.json.JsonOutput

def jsonfile = new File('data.json')
def jsoncontent = jsonfile.text


print jsoncontent.getClass()

def jsonSlurper = new JsonSlurper()
def jsondata = jsonSlurper.parseText(jsoncontent)

println jsondata