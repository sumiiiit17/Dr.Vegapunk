import groovy.json.JsonSlurper

def todosUrl = 'http://jsonplaceholder.typicode.com/todos'
def usersUrl = 'http://jsonplaceholder.typicode.com/users'
def todosJson = new URL(todosUrl).text
def usersJson = new URL(usersUrl).text
def jsonSlurper = new JsonSlurper()
def todos = jsonSlurper.parseText(todosJson)
def users = jsonSlurper.parseText(usersJson)

def userIdToName = [:]
users.each { user ->
    userIdToName[user.id] = user.name
}
def userStats = [:]
todos.each { todo ->
    def userId = todo.userId
    def completed = todo.completed

    if (!userStats.containsKey(userId)) {
        userStats[userId] = [total: 0, completed: 0]
    }

    userStats[userId].total += 1
    if (completed) {
        userStats[userId].completed += 1
    }
}

userStats.each { userId, stats ->
    def userName = userIdToName[userId]
    def totalTodos = stats.total
    def completedTodos = stats.completed
    def completionPercentage = Math.round((completedTodos * 100.0) / totalTodos)

    println "${userName} has ${totalTodos} todos, ${completedTodos} of which are completed giving him/her a completion percentage of ${completionPercentage}%"
}
