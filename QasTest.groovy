import groovy.json.JsonSlurper
import java.util.HashMap
def users = 'http://jsonplaceholder.typicode.com/users'
def todo = 'http://jsonplaceholder.typicode.com/todos'

def todourl = new URL(todo).text
def usersurl = new URL(users).text

def Jusonslurper = new JsonSlurper()

def todoJson = Jusonslurper.parseText(todourl)
def usersJson =  Jusonslurper.parseText(usersurl)

def useridToname = [:];
usersJson.each{user ->
useridToname[user.id] = user.name
}

def tasks = [:];
todoJson.each{task ->
    def id = task.userId
    def complete = task.completed

    if(!tasks.containsKey(id)){
        tasks[id] = [total:  0, completed: 0]
    }

    tasks[id].total += 1
    if(complete){
        tasks[id].completed += 1
    }
}
tasks.each{key,value ->     
    def name  = useridToname[key]
    def tot = value.total
    def com = value.completed
    def percentage =  Math.round((com * 100.0)/tot)

    println "${name} has ${tot} todos, ${com} of which are completed giving him/her a completion percantage  of ${percentage}%"
}
