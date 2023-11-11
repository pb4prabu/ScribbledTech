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
        brightness: Brightness.dark,
        primarySwatch: Colors.red,
      ),
      home: const MyHomePage(title: 'Flutter Demo'),
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
        title: Text(widget.title),shadowColor: Colors.yellow,backgroundColor: Colors.deepPurple,foregroundColor: Colors.yellow,
         elevation:0, toolbarHeight: 50,toolbarOpacity: 1, 
),
      
      body: Column(
        children: [
          Expanded(child: Container()),
          Center(
            child: Text("This is the HomePage..",
            textAlign: TextAlign.center,
            style: TextStyle(
              color: Colors.white,
              fontSize: 40.0,
              fontStyle: FontStyle.normal, 
          ),  
    )),
    //  Text("You are doing great, keep the spirits up all day",
    //  textAlign: TextAlign.center,
    //  style: TextStyle(
    //    color: Colors.white,
    //    fontSize: 40.0,
    //    fontStyle: FontStyle.normal, 
    //       ),  
          
    // ),
    // Text("Just see how this widget and its text is aligned center ",
    // textAlign: TextAlign.center,
    //  style: TextStyle(
    //    color: Colors.white,
    //    fontSize: 20.0,
    //    fontStyle: FontStyle.normal, 
    //       ),  
          
    // ),
    Expanded(child: Container()),
        ],
      ),
    floatingActionButton: FloatingActionButton(
          //icon: Icon(Icons.add),
          child: Icon(Icons.add_a_photo),
          backgroundColor: Colors.purple,
          foregroundColor: Colors.white,
          //label: Text('Give Feedback'),
          onPressed: () {
            print('FloatingActionButton clicked');
          },
        ),
      floatingActionButtonLocation: FloatingActionButtonLocation.miniEndFloat,
      backgroundColor: Colors.cyan,
      drawer: Drawer(
 child: Container(
   color: Colors.blueGrey,
   child: Center(
     child: Text("I'm a Drawer!",
     style: TextStyle(
              color: Colors.white,
              fontSize: 40.0,
              fontStyle: FontStyle.normal),
   ),
 ),
),
      )
//Alessandria, Simone; Kayfitz, Brian. Flutter Cookbook: Over 100 proven techniques and solutions for app development with Flutter 2.2 and Dart (p. 101). Packt Publishing. Kindle Edition. 
    );
  }
}
// centerDocked
// centerFloat
// centerTop
// endDocked
// endFloat
// endTop
// miniCenterDocked
// miniCenterFloat
// miniCenterTop
// miniEndDocked
// miniEndFloat
// miniEndTop
// miniStartDocked
// miniStartFloat
// miniStartTop
// startDocked
// startFloat
// startTop
