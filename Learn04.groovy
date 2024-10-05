import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import java.util.HashMap
def todourl =  new URL("http://jsonplaceholder.typicode.com/todos")
def usersurl = new URL("http://jsonplaceholder.typicode.com/users")

def jsonslurper = new JsonSlurper()

def todojson = jsonslurper.parse(todourl)
def userjson = jsonslurper.parse(usersurl)

def userIdToName =[:]
userjson.each{user   ->
userIdToName[user.id] = user.name
}

todo = [:]
todojson.each{task ->
def id =  task.userId
def complete = task.completed
    if(!todo.containsKey(id)){
        todo[id] = [total: 0, complete: 0]
    }
    todo[id].total +=1
    if(complete){
        todo[id].complete +=1
    }
}
ans = [:]
todo.each{userID, stats ->
def name =  userIdToName[userID]
def totalTodos =  stats.total
def completedTodos = stats.complete
def percentagetodo = Math.round((completedTodos * 100.0)/ totalTodos)
    if(!ans.containsKey(name)){
        ans[name] = [total : 0, completed : 0, percentage : ""]
    }
    ans[name].total = totalTodos
    ans[name].completed = completedTodos
    ans[name].percentage = "${percentagetodo}%"
println "${name} has ${totalTodos} todos, ${completedTodos} of which are completed giving him/her a completion percentage of ${percentagetodo}%"
}
def file = new File('ansfile.json')
def jsonoutput = JsonOutput.toJson(ans)
file.write(jsonoutput)