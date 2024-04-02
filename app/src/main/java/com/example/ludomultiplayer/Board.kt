package com.example.ludoletsplay

class Board {
    private var idx: Int = 0
    private var path = mutableMapOf<Int,Pair>()
    fun getPathMap(i:Int): Pair{
        return path[i]!!
    }
    fun setPathMap(){
        idx = 0
        for(i in 0..4){
            path[idx++] = Pair(6.5f-0.24f,14.5f-1.9f-i)
        }
        for(i in 0..5){
            path[idx++] = Pair(5.5f-0.3f-i,8.5f-0.8f)
        }
        for(i in 0..1){
            path[idx++] = Pair(0.28f,7.5f-0.8f-i)
        }
        for(i in 0..4){
            path[idx++] = Pair(1.5f-0.28f+i,6.5f-0.8f)
        }

        for(i in 0..5){
            path[idx++] = Pair(6.5f, 5.5f-i)
        }
        for(i in 0..1){
            path[idx++] = Pair(7.5f+i, 0.5f)
        }
        for(i in 0..4){
            path[idx++] = Pair(8.5f, 1.5f+i)
        }
        for(i in 0..5){
            path[idx++] = Pair(9.5f+i, 6.5f)
        }
        for(i in 0..1)
            path[idx++] = Pair(14.5f, 7.5f+i)
        for(i in 0..4)
            path[idx++] = Pair(13.5f-i,8.5f)
        for(i in 0..5)
            path[idx++] = Pair(8.5f, 9.5f+i)
        for(i in 0..1)
            path[idx++] = Pair(7.5f-i,14.5f)
        for(i in 0..5)
            path[idx++] = Pair(7.5f,13.5f-i)
        for(i in 0..5)
            path[idx++] = Pair(1.5f+i,7.5f)
        for(i in 0..5)
            path[idx++] = Pair(7.5f, 1.5f+i)
        for(i in 0..5)
            path[idx++] = Pair(13.5f-i,7.5f)

    }
}
class Pair(x: Float, y: Float){
    val x = x
    val y = y
}