import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("APPBAR TEXT"),shadowColor: Colors.yellow,backgroundColor: Colors.deepPurple,foregroundColor: Colors.yellow,
         elevation:0, toolbarHeight: 50,toolbarOpacity: 1, 
),
      
      body: Center(
        child: Text("This is body of Scaffold",
        style: TextStyle(
          color: Colors.white,
          fontSize: 40.0,
          fontStyle: FontStyle.normal, 
      ),  
    )),
    floatingActionButton:FloatingActionButton(
          elevation: 0.0,
          backgroundColor: Colors.purple,
          foregroundColor: Colors.white,
          //child: Icon(Icons.sailing_rounded),
          //child: Icon(Icons.radar_outlined),
          child: Icon(Icons.table_rows_sharp),
          //mouseCursor: MaterialStateMouseCursor.textable,
          //tooltip: "Hello, I am Floating button ",
          //hoverColor: Colors.black,
          onPressed: (){
           // print('I am Floating button');
          }
          
      ), 
      floatingActionButtonLocation: FloatingActionButtonLocation.centerDocked,
      backgroundColor: Colors.cyan
      
    );
  }
}
