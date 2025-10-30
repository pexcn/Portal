package moe.fuqiuluo.portal.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.material.button.MaterialButton
import moe.fuqiuluo.portal.ui.mock.MockFragment
import moe.fuqiuluo.portal.ui.viewmodel.MockServiceViewModel

class MockSwitchReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val fragment = MockFragment.getInstance() ?: return
        val vm: MockServiceViewModel = fragment.mockServiceViewModel
        val command = intent.getStringExtra("command")?.lowercase() ?: "start"

        when (command) {
            "start" -> fragment.tryOpenService(MaterialButton(fragment.requireContext()))
            "stop"  -> fragment.tryCloseService(MaterialButton(fragment.requireContext()))
            else    -> fragment.tryOpenService(MaterialButton(fragment.requireContext()))
        }
    }
}
