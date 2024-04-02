package com.example.ludoletsplay

import android.content.Context
import android.graphics.*
import android.graphics.Paint.Style
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.ludomultiplayer.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LudoBoard(context: Context?, attributeSet: AttributeSet?) : View(context, attributeSet) {

    private var width: Int = 0
    private var height: Int = 0
    private var shift: Float = 0f
    private var p: Int = 0
    val paint = Paint()
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w
        height = h
        shift = (height - width) / 2f
        p = width / 15

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        player1(canvas!!)
        player2(canvas!!)
        player3(canvas!!)
        player4(canvas!!)
        movePiece(canvas!!)
        drawGrids(canvas!!)
        paint.style = Style.STROKE
        canvas!!.drawRect(0f, shift, width * 1f, shift + width, paint)
        canvas!!.drawRect(p * 6f, shift + p * 6f, p * 9f, shift + p * 9f, paint)
        canvas!!.drawRect(0f, shift, p * 6f, shift + p * 6f, paint)
        canvas!!.drawRect(0f, shift + p * 9f, p * 6f, shift + width, paint)
        canvas!!.drawRect(p * 9f, shift, width * 1f, shift + p * 6f, paint)
        canvas!!.drawRect(p * 9f, shift + p * 9f, width * 1f, shift + width, paint)
        canvas!!.drawLine(p * 6f, shift + p * 6f, p * 9f, shift + p * 9f, paint)
        canvas!!.drawLine(p * 6f, shift + p * 9f, p * 9f, shift + p * 6f, paint)
    }

    private fun drawGrids(canvas: Canvas) {
        canvas.drawLine(p * 7f, shift + p * 9f, p * 7f, shift + width, paint)
        canvas.drawLine(p * 8f, shift + p * 9f, p * 8f, shift + width, paint)

        canvas.drawLine(0f, shift + p * 8f, p * 6f, shift + p * 8f, paint)
        canvas.drawLine(0f, shift + p * 7f, p * 6f, shift + p * 7f, paint)

        for (i in 10..14) {
            canvas.drawLine(p * 6f, shift + i * 1f * p, p * 9f, shift + i * 1f * p, paint)
            canvas.drawLine(
                p * 6f,
                shift + (i - 9) * 1f * p,
                p * 9f,
                shift + (i - 9) * 1f * p,
                paint
            )
        }

        canvas.drawLine(p * 7f, shift, p * 7f, shift + p * 6f, paint)
        canvas.drawLine(p * 8f, shift, p * 8f, shift + p * 6f, paint)

        canvas.drawLine(p * 9f, shift + p * 7f, width * 1f, shift + p * 7f, paint)
        canvas.drawLine(p * 9f, shift + p * 8f, width * 1f, shift + p * 8f, paint)

        for (i in 1..5) {
            canvas.drawLine(p * i * 1f, shift + p * 6f, p * i * 1f, shift + p * 9f, paint)
            canvas.drawLine(p * (i + 9f), shift + p * 6f, p * (i + 9f), shift + p * 9f, paint)

        }
    }

    private fun player1(canvas: Canvas) {
        paint.color = Color.RED
        canvas!!.drawRect(0f, shift + p * 9f, p * 6f, shift + width, paint)
        val path = Path()
        path.moveTo(width / 2f, shift + p * (7.5f))
        path.lineTo(p * 6f, shift + p * 9f)
        path.lineTo(p * 9f, shift + p * 9f)
        path.close()

        canvas.drawRect(p * 6f, shift + p * 13f, p * 7f, shift + p * 14f, paint)
        for (i in 0..4)
            canvas.drawRect(p * 7f, shift + p * (13f - i), p * 8f, shift + p * (14f - i), paint)

        canvas.drawPath(path, paint)
        paint.color = Color.BLACK
        paint.style = Style.STROKE

        canvas.drawRect(p * 1f, shift + p * 10f, p * 5f, shift + width - p * 1f, paint)
        paint.color = Color.WHITE
        paint.style = Style.FILL
        canvas.drawRect(p * 1f, shift + p * 10f, p * 5f, shift + width - p * 1f, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        canvas.drawCircle(p * 2f, shift + p * 11f, p * 0.5f, paint)
        canvas.drawCircle(p * 2f, shift + p * 13f, p * 0.5f, paint)
        canvas.drawCircle(p * 4f, shift + p * 11f, p * 0.5f, paint)
        canvas.drawCircle(p * 4f, shift + p * 13f, p * 0.5f, paint)
        paint.style = Paint.Style.FILL
        paint.color = Color.RED
        canvas.drawCircle(p * 2f, shift + p * 11f, p * 0.5f, paint)
        canvas.drawCircle(p * 2f, shift + p * 13f, p * 0.5f, paint)
        canvas.drawCircle(p * 4f, shift + p * 11f, p * 0.5f, paint)
        canvas.drawCircle(p * 4f, shift + p * 13f, p * 0.5f, paint)
    }

    private fun player2(canvas: Canvas) {
        paint.color = Color.BLUE
        canvas!!.drawRect(0f, shift, p * 6f, shift + p * 6f, paint)
        val path = Path()
        path.moveTo(width / 2f, shift + p * (7.5f))
        path.lineTo(p * 6f, shift + p * 9f)
        path.lineTo(p * 6f, shift + p * 6f)
        path.close()
        canvas.drawPath(path, paint)

        canvas.drawRect(p * 1f, shift + p * 6f, p * 2f, shift + p * 7f, paint)
        for (i in 0..4) {
            canvas.drawRect(p * (1f + i), shift + p * 7f, p * (2f + i), shift + p * 8f, paint)
        }

        paint.color = Color.BLACK
        paint.style = Style.STROKE
        canvas.drawRect(p * 1f, shift + p * 1f, p * 5f, shift + p * 5f, paint)
        paint.color = Color.WHITE
        paint.style = Style.FILL
        canvas.drawRect(p * 1f, shift + p * 1f, p * 5f, shift + p * 5f, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        canvas.drawCircle(p * 2f, shift + p * 2, p * 0.5f, paint)
        canvas.drawCircle(p * 4f, shift + 2 * p, p * 0.5f, paint)
        canvas.drawCircle(p * 2f, shift + 4 * p, p * 0.5f, paint)
        canvas.drawCircle(p * 4f, shift + 4 * p, p * 0.5f, paint)
        paint.style = Paint.Style.FILL
        paint.color = Color.BLUE
        canvas.drawCircle(p * 2f, shift + p * 2, p * 0.5f, paint)
        canvas.drawCircle(p * 4f, shift + 2 * p, p * 0.5f, paint)
        canvas.drawCircle(p * 2f, shift + 4 * p, p * 0.5f, paint)
        canvas.drawCircle(p * 4f, shift + 4 * p, p * 0.5f, paint)
    }

    private fun player3(canvas: Canvas) {
        paint.color = Color.YELLOW
        canvas!!.drawRect(p * 9f, shift, width * 1f, shift + p * 6f, paint)
        val path = Path()
        path.moveTo(width / 2f, shift + p * (7.5f))
        path.lineTo(p * 6f, shift + p * 6f)
        path.lineTo(p * 9f, shift + p * 6f)
        path.close()
        canvas.drawPath(path, paint)

        canvas.drawRect(p * 8f, shift + p * 1f, p * 9f, shift + p * 2f, paint)
        for (i in 0..4)
            canvas.drawRect(p * 7f, shift + p * (1f + i), p * 8f, shift + p * (2f + i), paint)

        paint.color = Color.WHITE
        canvas.drawRect(p * 10f, shift + p * 1f, p * 14f, shift + p * 5f, paint)
        paint.color = Color.BLACK
        paint.style = Style.STROKE



        canvas.drawRect(p * 10f, shift + p * 1f, p * 14f, shift + p * 5f, paint)
        canvas.drawCircle(p * 11f, shift + p * 2, p * 0.5f, paint)
        canvas.drawCircle(p * 13f, shift + 2 * p, p * 0.5f, paint)
        canvas.drawCircle(p * 11f, shift + 4 * p, p * 0.5f, paint)
        canvas.drawCircle(p * 13f, shift + 4 * p, p * 0.5f, paint)
        paint.style = Paint.Style.FILL
        paint.color = Color.YELLOW
        canvas.drawCircle(p * 11f, shift + p * 2, p * 0.5f, paint)
        canvas.drawCircle(p * 13f, shift + 2 * p, p * 0.5f, paint)
        canvas.drawCircle(p * 11f, shift + 4 * p, p * 0.5f, paint)
        canvas.drawCircle(p * 13f, shift + 4 * p, p * 0.5f, paint)
    }

    private fun player4(canvas: Canvas) {
        paint.color = Color.GREEN
        canvas!!.drawRect(p * 9f, shift + p * 9f, width * 1f, shift + width, paint)
        val path = Path()
        path.moveTo(width / 2f, shift + p * (7.5f))
        path.lineTo(p * 9f, shift + p * 9f)
        path.lineTo(p * 9f, shift + p * 6f)
        path.close()
        canvas.drawPath(path, paint)
        canvas.drawRect(p * 13f, shift + p * 8f, p * 14f, shift + p * 9f, paint)
        for (i in 0..4)
            canvas.drawRect(p * (13f - i), shift + p * 7f, p * (14f - i), shift + p * 8f, paint)
        paint.color = Color.WHITE
        canvas.drawRect(p * 10f, shift + p * 10f, p * 14f, shift + p * 14f, paint)
        paint.style = Style.STROKE
        paint.color = Color.BLACK
        canvas.drawRect(p * 10f, shift + p * 10f, p * 14f, shift + p * 14f, paint)
        canvas.drawCircle(p * 11f, shift + p * 11, p * 0.5f, paint)
        canvas.drawCircle(p * 13f, shift + 11 * p, p * 0.5f, paint)
        canvas.drawCircle(p * 11f, shift + 13 * p, p * 0.5f, paint)
        canvas.drawCircle(p * 13f, shift + 13 * p, p * 0.5f, paint)
        paint.style = Style.FILL
        paint.color = Color.GREEN
        canvas.drawCircle(p * 11f, shift + p * 11, p * 0.5f, paint)
        canvas.drawCircle(p * 13f, shift + 11 * p, p * 0.5f, paint)
        canvas.drawCircle(p * 11f, shift + 13 * p, p * 0.5f, paint)
        canvas.drawCircle(p * 13f, shift + 13 * p, p * 0.5f, paint)
    }

    private fun movePiece(canvas: Canvas) {
        paint.color = Color.DKGRAY
        paint.style = Style.STROKE
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.red)
        val radius = p * 0.48f
        val scaleFactor = radius * 2 / Math.max(bitmap.width, bitmap.height)
        val scaledWidth = (bitmap.width * scaleFactor).toInt()
        val scaledHeight = (bitmap.height * scaleFactor).toInt()
        bitmap = Bitmap.createScaledBitmap(bitmap, scaledWidth, scaledHeight, true)
        val board = Board()
        board.setPathMap()
        for (i in 0..17) {
            val pair = board.getPathMap(i)
            val x = p * pair.x - 1
            val y = shift + p * pair.y - 5



        }
    }
}