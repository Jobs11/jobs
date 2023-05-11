import java.util.Scanner

class login {
}

val a = Scanner(System.`in`)
fun main(){

    println("아이디를 입력하세요.")
    var ID: String = a.nextLine()
    println("비밀번호를 입력하세요.")
    var PW: String = a.nextLine()
    println("이메일을 입력하세요.")
    var email: String = a.nextLine()
    println("전화번호를 입력하세요.")
    var phone: String = a.nextLine()

    var user = User(ID, PW, email, phone)

    println(user)

    println("로그인 아이디를 입력하세요.")
    var Rid: String = a.nextLine()
    println("로그인 비밀번호를 입력하세요.")
    var Rpw: String = a.nextLine()

    val Lg = Slogin(user.ID, user.PW)

    Lg.reLg(Rid, Rpw)

    a.close()

}

data class User(val ID: String, val PW: String, val email: String, val phone: String){

}

class Slogin(ID: String, PW: String ){
    var Rid = ID
    var Rpw = PW

    fun reLg(ID: String, PW: String) {

        if (ID.equals(Rid) && PW.equals(Rpw)) {
            println("로그인 성공")
        }
        else {
            println("로그인 실패")
        }
    }


}

class Register(){

}