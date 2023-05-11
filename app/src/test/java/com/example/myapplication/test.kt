package com.example.myapplication

class test {
}

fun main(){
    val user2 = User2("이름", 8)
    println("user2사용해보기 " + user2)

    var user = User("seo")

    println("user의 name: "+user.name)
    user.someFun()

    var data11 = arrayOf<Int>(1,2,3)
    for ( (index, value) in data11.withIndex()){
        print(" 인덱스의 값")
        print(index)
        print("value의 값")
        print(value)
        if (index != data11.size-1) println(",")
    }

    fun sum10 ():Int {
        val result = 0
        for ( i in 10 downTo 1){
            val sum = 0
            val result = sum + i
            println("result의 값은 : $result")
        }
        return result

    }
    sum10()


    var obj = Sub()
    println("obj.superData: $obj.superData")
    obj.superFun()

    val none1 = NonDataClass("SEA", "1234", "ema1")
    val none2 = NonDataClass("AES", "1234", "ema2")
    println("none1의 주소값: $none1")
    println("none2의 주소값: $none2")
    println("equals의 주소값: ${none1.equals(none2)}")

    val data13 = DataClass("SEA", "1234")
    val data14 = DataClass("SEA", "1234")
    println("data13의 주소값: $data13")
    println("data14의 주소값: $data14")
    println("equals의 주소값: ${data13.equals(data14)}")

    obje.data = 20
    obje.some()
    /*obj.data = 20
    obj.some()*/
    companionClassTest.data
    companionClassTest.some()

    fun some(no1:Int, no2:Int):Int {
        return no1+no2
    }

    val result13 = {no1:Int, no2:Int -> no1+no2}
    val x = result13(1,2)
    println(x)

    val result14 = {no1:Int -> println("no1 = $no1")}
    val y = result14(5)
    println(y)

    val some2 = {no1:Int, no2:Int -> println("출력")
     no1 * no2 }
    println("익명 ${some2(1,2)}")

    val result16 = testH({ no -> no > 0 })
    println("result16?  $result16")

    val data20:String? = "seeeeeeeeeee"
    println("data20의 길이: ${data20?.length ?: 0}")

}


fun testH(arg: (Int)-> Boolean ) :() -> String {
    val result = if(arg(10)) {
        "valid"
    }else {
        "invalid"
    }
    return {"testH result: $result"}

}

class companionClassTest {
    companion object {
        var data = 10
        fun some() {
            println("data의 값은 $data")
        }
    }
}

open class Super2 {
    open var data = 10
    open fun some(){
        println("i am Super2: $data")
    }
}

var obje = object : Super2(){
    override var data = 20
    override fun some(){
        println("i am Super2 재사용한 값: $data")
    }
}

class NonDataClass(val name: String, val pw: String, val email: String){
    /*lateinit var email:String
    constructor(name: String, pw: String, email: String): this(name, pw){
        this.email

    }*/
}

data class DataClass(val name: String, val pw: String){

}



open class Super{
    open var superData = 10
    protected var protectedData = 20
    open fun superFun(){
        println("superFun 호출됨")
    }

}

class Sub: Super(){
    override var superData = 20
    override fun superFun(){
        println(protectedData++)
    }



}

class User3(name: String){

    constructor(name: String, count: Int) : this(name)
    {

    }
}


class User2(name: String, count: Int){

    var name="sea"
    init {
        println("init 호출. 주생성자 매개변수 사용: $name")
    }

    fun someFun(){
        println("init 호출. 주생성자 매개변수 사용: $name")
    }

}

class User {
    var name = "sea"
    constructor(name: String){
        this.name = name
    }
    fun someFun() {
        println ("name: $name")
    }
}

