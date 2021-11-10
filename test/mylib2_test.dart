import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:mylib2/mylib2.dart';

void main() {
  const MethodChannel channel = MethodChannel('mylib2');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await Mylib2.platformVersion, '42');
  });
}
