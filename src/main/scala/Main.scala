import utils.GenerateMultipleJson

@main def hello(args: String*): Unit = 
  println("Hello Writing JSON FIS log now!")
  
  GenerateMultipleJson.main(args.toArray)
  println(msg)

def msg = "I was compiled by Scala 3. :)"

