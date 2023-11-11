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

final GlobalKey<ScaffoldState> _scaffoldKey = GlobalKey<ScaffoldState>();
void _openDrawer() {
  _scaffoldKey.currentState!.openDrawer();
}

void _closeDrawer() {
  Navigator.of(context).pop();
}



  @override
  Widget build(BuildContext context) {
    return Scaffold(
//       appBar: AppBar(
//         title: Text(widget.title),shadowColor: Colors.yellow,backgroundColor: Colors.deepPurple,foregroundColor: Colors.yellow,
//          elevation:0, toolbarHeight: 50,toolbarOpacity: 1, 
// ),
      
//       body: Column(
//         children: [
//           Expanded(child: Container()),
//           Center(
//             child: Text("This is the HomePage..",
//             textAlign: TextAlign.center,
//             style: TextStyle(
//               color: Colors.white,
//               fontSize: 40.0,
//               fontStyle: FontStyle.normal, 
//           ),  
//     )),
    
//     Expanded(child: Container()),
//         ],
//       ),

    key: _scaffoldKey,
    appBar: AppBar(title: const Text('Drawer Demo')),
    body: Center(
    //   child: ElevatedButton(
    //     onPressed: _openDrawer,
    //     child: const Text('Open Drawer'),
    //   ),
    ),
    
      backgroundColor: Colors.cyan,
      primary: false,
      // drawer: Drawer(
      //   child: Container(
      //   color: Colors.blueGrey,
      // child: Center(
      //   child: Column(
      //     mainAxisAlignment: MainAxisAlignment.center,
      //     children: <Widget>[
      //       const Text('This is the Drawer',style: TextStyle(
      //          color: Colors.white,
      //          fontSize: 40.0,
      //          //textAlign: TextAlign.center,
      //         fontStyle: FontStyle.normal)),
            
      //       ElevatedButton(
      //         onPressed: _closeDrawer,
      //         child: const Text('Close Drawer'),
      //       ),
      //     ],
      //   ),
      // ),
      
      // ),
      // ), 
      // Disable opening the drawer with a swipe gesture.
    drawerEnableOpenDragGesture: false,
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
      ),
      // endDrawer: Drawer(
      //   child: ListView.builder(
      //     itemCount: 3,
      //     itemBuilder: (
      //       BuildContext context,int index){
      //     return ListTile(
      //       leading: const Icon(Icons.list),
      //       title: Text("Item ${index+1}"),
      //       trailing: const Icon(Icons.done),
      //     );
      //   }),
        //elevation: 20.0,
        //semanticLabel: 'endDrawer',
        endDrawerEnableOpenDragGesture: true,
    endDrawer: Drawer(
 child: Container(
   color: Colors.blueGrey,
   child: Center(
     child: Text("I'm an endDrawer!",
     style: TextStyle(
              color: Colors.white,
              fontSize: 40.0,
              fontStyle: FontStyle.normal),
   ),
 ),
),
      )
    );
    
  }
}

