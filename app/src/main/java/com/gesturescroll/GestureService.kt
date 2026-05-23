package com.gesturescroll

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.view.accessibility.AccessibilityEvent

class GestureService : AccessibilityService() {
    companion object {
        var instance: GestureService? = null
    }
    override fun onServiceConnected() {
        instance = this
    }
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}
    override fun onInterrupt() {}
    override fun onDestroy() {
        instance = null
    }
    fun swipeUp() {
        val path = Path()
        path.moveTo(540f, 1600f)
        path.lineTo(540f, 400f)
        val gesture = GestureDescription.Builder()
            .addStroke(GestureDescription.StrokeDescription(path, 0, 200))
            .build()
        dispatchGesture(gesture, null, null)
    }
    fun swipeDown() {
        val path = Path()
        path.moveTo(540f, 400f)
        path.lineTo(540f, 1600f)
        val gesture = GestureDescription.Builder()
            .addStroke(GestureDescription.StrokeDescription(path, 0, 200))
            .build()
        dispatchGesture(gesture, null, null)
    }
}
