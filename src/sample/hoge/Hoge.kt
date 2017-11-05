package sample.hoge

/**
 * Created by satoutakeshi on 2017/11/05.
 */
class Foo {

}

//どこからでもアクセス可能
public fun publicFunction(){}

//同一モジュール内に限り全公開
internal fun internalFunction(){}

//同一ファイル内のみアクセス可能
private fun privateFunction(){}

/**
 * クラスにおける可視性修飾子
 */

open class Foo2{
    private fun privateMethod(){}
    protected fun protectedMethod(){}
}

class Bar: Foo2(){
    fun execute(){
        //privateMethod()
        protectedMethod()
    }
}
open class Hoge private constructor()
//class Fuga: Hoge() //コンパイルエラー
