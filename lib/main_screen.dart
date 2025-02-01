import 'package:flutter/material.dart';

class MainScreen extends StatelessWidget {
  const MainScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Sporty UP", style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold, color: Colors.blue)),
        centerTitle: true,
        backgroundColor: Colors.white,
        elevation: 1,
        leading: IconButton(
          icon: const Icon(Icons.menu, color: Colors.black),
          onPressed: () {}, // TODO: 사이드 메뉴 기능 추가
        ),
        actions: [
          IconButton(
            icon: const Icon(Icons.help_outline, color: Colors.black),
            onPressed: () {}, // TODO: 도움말 기능 추가
          ),
        ],
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // 🔍 검색창
              TextField(
                decoration: InputDecoration(
                  hintText: "Search...",
                  prefixIcon: const Icon(Icons.search),
                  suffixIcon: DropdownButton<String>(
                    items: const [
                      DropdownMenuItem(value: "value1", child: Text("Value 1")),
                      DropdownMenuItem(value: "value2", child: Text("Value 2")),
                    ],
                    onChanged: (value) {},
                  ),
                  border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
                ),
              ),
              const SizedBox(height: 20),

              // 📢 배너 이미지
              ClipRRect(
                borderRadius: BorderRadius.circular(12),
                child: Image.asset("assets/banner.png", fit: BoxFit.cover),
              ),
              const SizedBox(height: 20),

              // 🔥 최근 시청한 강의
              const Text("최근 시청한 강의", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
              const SizedBox(height: 10),
              Row(
                children: [
                  Expanded(child: Image.asset("assets/lecture1.png", fit: BoxFit.cover)),
                  const SizedBox(width: 10),
                  Expanded(child: Image.asset("assets/lecture2.png", fit: BoxFit.cover)),
                ],
              ),
              const SizedBox(height: 20),

              // 🏋️ 주완님을 위한 제품
              const Text("주완님을 위한 제품", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
              const SizedBox(height: 10),
              Row(
                children: [
                  Expanded(child: Image.asset("assets/product1.png", fit: BoxFit.cover)),
                  const SizedBox(width: 10),
                  Expanded(child: Image.asset("assets/product2.png", fit: BoxFit.cover)),
                ],
              ),
            ],
          ),
        ),
      ),

      // ⬇️ 하단 네비게이션 바
      bottomNavigationBar: BottomNavigationBar(
        items: const [
          BottomNavigationBarItem(icon: Icon(Icons.home), label: "Home"),
          BottomNavigationBarItem(icon: Icon(Icons.shopping_cart), label: "Shop"),
          BottomNavigationBarItem(icon: Icon(Icons.person), label: "Profile"),
        ],
      ),
    );
  }
}
