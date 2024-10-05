def reverseString(String str) {
def reversed = ""
    for (i in (str.length() - 1)..0) {
        reversed += str[i]
    }
    return reversed
}
println(reverseString("hello")) 