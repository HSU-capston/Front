import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Sporty UP',
      home: Scaffold(
        appBar: AppBar(title: const Text('Sporty UP')),
        body: const Center(
          child: Text(
            'Welcome to Sporty UP!',
            style: TextStyle(fontSize: 24),
          ),
        ),
      ),
    );
  }
}
