/**
 * Created by satoutakeshi on 2017/11/05.
 */
//package sample.fuga
import sample.hoge.Foo
import sample.hoge.publicFunction
//import sample.fuga.Baz as Beer
fun main(args: Array<String>) {

    //Personをインスタンス化
    val person: Person = Person("ゆたか")
    person.introduceMyself() // I am ゆたか

    //サブクラス Studentをインスタンス化
    val student: Student = Student("くみこ", 123)
    println(student.id)
    println(student.name)
    //student.introduceMyself() // I am くみこ

    //継承するとスーパークラスのメンバをサブクラスが自動的に持つようになる。
    // StudentはスーパークラスのintroduceMyselfメソッドを自動的に受け継ぐ
    //継承する時にスーパークラスにはなかったプロパティを追加できる。
    //ここではidプロパティ

    //オーバーライドでスーパークラスのメソッドを書き換える
    student.introduceMyself()

    /**
     * スーパータイプとサブタイプ
     */

    //Person型としてStudentをインスタンス化
    val person2: Person = Student("たろう", 456)
    person2.introduceMyself() // "I am たろう(id=456)"のサブクラスのメソッドが実行される
    // person2.id //Error:(31, 13) Kotlin: Unresolved reference: id
    // -> 型がPersonなのでプロパティidがない

    /**
     * すべてのクラスのルートクラスAny
     *
     * toString():String
     * equals(other:Any?):Boolean
     * hashCode():Int
     */
    val person3 :Any = Person("たけし")

    //抽象クラス
    EnglishGreeter("Kotlin").sayHello()
    JapaneseGreeter("Java").sayHello()

    /**
     * 可視性
     */

    println(sample.hoge.Foo())

   // publicFunction()
    //privateFunction()

}

//スーパークラス(open)をつけると継承可能になる。
// プロパティもopenをつければサブクラスでオーバーライドできる。
open class Person(open val name: String) {
   open fun introduceMyself() {
        println("I am $name.")
    }
}

//サブクラス
//スーパークラスがopenついてればサブクラスでオーバーライドできる。
class Student(override val name: String, val id: Long): Person(name) {
    override fun introduceMyself() {
        println("I am $name (id=$id)")

//        //スーパークラスの実装をそのまま使う
//        println("--自己紹介ここから--")
//        super.introduceMyself()
//        println("--自己紹介ここまで--")
    }
}

/**
 * 抽象クラス
 *
 * 抽象メンバー
 *  ・サブクラスにメンバのオーバーライドを強制する
 *  ・抽象メンバは実装を持たないがサブクラス側はオーバーライドをする義務を負う
 *
 *  ->インターフェイスとの関係はどうなっているんだろう？
 *  https://kotlinlang.org/docs/reference/interfaces.html
 *  What makes them different from abstract classes is that interfaces cannot store state.
 *  保持する状態をインターフェイスでは定義ができない。プロパティは抽象プロパティか、アクセッサーの実装が必要。（バッキングフィールドはない）
 */

abstract class Greeter(val target: String){
    abstract fun sayHello()
}

//抽象クラスGreeterを継承
class EnglishGreeter(target: String) : Greeter(target) {
    override fun sayHello() {
        println("Hello, $target!")
    }
}

//抽象クラスGreeterを継承
class JapaneseGreeter(target: String): Greeter(target) {
    override fun sayHello() {
        println("こんにちは、$target!")
    }
}



//https://kotlinlang.org/docs/reference/classes.html

class Baz

//可視性
class Bar {
    fun dosomethingGoog(){
        Foo() //import sample.hoge.FooしているからOK
        sample.hoge.Foo() // パッケージ名で指定もOK
        //Beer()  //import sample.fuga.Baz as BeerだからOK

    }
}

