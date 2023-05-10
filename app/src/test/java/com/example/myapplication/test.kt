package com.example.myapplication

import android.provider.ContactsContract.CommonDataKinds.Email

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

    val none1 = NonDataClass("SEA", "1234")
    val none2 = NonDataClass("AES", "1234")
    println("none1의 주소값: $none1")
    println("none2의 주소값: $none2")
    println("equals의 주소값: ${none1.equals(none2)}")

    val data13 = DataClass("SEA", "1234")
    val data14 = DataClass("SEA", "1234")
    println("data13의 주소값: $data13")
    println("data14의 주소값: $data14")
    println("equals의 주소값: ${data13.equals(data14)}")


}

class NonDataClass(val name: String, val pw: String){
    lateinit var email:String
    constructor(name: String, pw: String, email: Email): this(name, pw){
        this.email

    }
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

