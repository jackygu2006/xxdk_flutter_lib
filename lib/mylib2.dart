import 'dart:async';

import 'package:flutter/services.dart';

class Mylib2 {
  static const MethodChannel _channel = const MethodChannel('mylib2');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<String> test(String str) async {
    return await _channel.invokeMethod('test', str);
  }

  static Future<String> getVersion() async {
    return await _channel.invokeMethod('getVersion');
  }

  static Future<String> getCMIXParams() async {
    return await _channel.invokeMethod('getCMIXParams');
  }

  static Future<String> getGitVersion() async {
    return await _channel.invokeMethod('getGitVersion');
  }

  static Future<String> getNetworkParams() async {
    return await _channel.invokeMethod('getNetworkParams');
  }

  static Future<String> getUnsafeParams() async {
    return await _channel.invokeMethod('getUnsafeParams');
  }

  static Future<String> getE2EParams() async {
    return await _channel.invokeMethod('getE2EParams');
  }

  static Future<String> getDependencies() async {
    return await _channel.invokeMethod('getDependencies');
  }

  static Future<String> getClientSingleton() async {
    return await _channel.invokeMethod('getClientSingleton');
  }
}
