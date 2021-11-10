package com.jackygu.mylib2

import androidx.annotation.NonNull
import bindings.Bindings

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import bindings.Client
import bindings.Message

/** Mylib2Plugin */
class Mylib2Plugin: FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "mylib2")
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    when (call.method) {
      "getPlatformVersion" -> {
        result.success("Android ${android.os.Build.VERSION.RELEASE}")
      }
      "test" -> {
        result.success("Hello");
      }
      "getVersion" -> {
        result.success(Bindings.getVersion());
      }
      "getCMIXParams" -> {
        result.success(Bindings.getCMIXParams());
      }
      "getGitVersion" -> {
        result.success(Bindings.getGitVersion());
      }
      "getNetworkParams" -> {
        result.success(Bindings.getNetworkParams());
      }
      "getUnsafeParams" -> {
        result.success(Bindings.getUnsafeParams());
      }
      "getE2EParams" -> {
        result.success(Bindings.getE2EParams());
      }
      "getDependencies" -> {
        result.success(Bindings.getDependencies());
      }
      "getClientSingleton" -> {
        result.success(Bindings.getClientSingleton());
      }
      "newClient" -> {

      }
      "login" -> {

      }
//     else if (call.method == "convert") {
//       val args = call.arguments
//       if (args is Int) {
//         try {
//           result.success(Num2words.convert(args.toLong()))
//         } catch (e: IllegalArgumentException) {
//           result.error("BAD_ARGS", e.message!!, null)
//         } catch (e: Exception) {
//           result.error("NATIVE_ERR", e.message!!, null)
//         }
//       } else {
//         result.error("BAD_ARGS", "Wrong argument types", null)
//       }
//     }
      else -> {
        result.notImplemented()
      }
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}
