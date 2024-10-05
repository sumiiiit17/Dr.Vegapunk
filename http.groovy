import groovy.json.JsonSlurper
import java.net.URL

def url = new URL('https://jsonplaceholder.typicode.com/todos/1')
def connection = url.openConnection()
connection.setRequestMethod("GET")

// Check the response code
if (connection.responseCode == 200) {
    def response = connection.inputStream.text
    def json = new JsonSlurper().parseText(response)
    println "Title: ${json.title}"
} else {
println "Failed to fetch data: ${connection.responseCode}"
}