// def list = [1,"App",3,4]
// list.each {println it * 1}
// list.remove("App")
// class Example {
//    static void main(String[] args) {
//       def x = 5
//       println('Hello World');  
//    }
// }
//  def range =  5..10;
//  println (range)
//  println (range.get(2))
// class Example { 
//    static void main(String[] args) { 
//       def range = 5..10; 
//       println(range); 
//       println(range.get(2)); 
//    } 
// }
for(int i in 5..10){
    println i
}
def f = 3
def v = 5
if (f.equals(v)){
    println "No"
}
else{
    println (Integer.toString(12))
}
double x = 11.635;
double y = 2.76;  
printf("The value of e is %.4f%n", Math.E); 
printf("exp(%.3f) is %.3f%n", x, Math.exp(x));
z = "Sumit"
println(z.previous())
println(z.reverse())
def t = []
t = z.split('m')
 for(def val : t)
 {
    println(val)
 }