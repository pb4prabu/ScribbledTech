import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  static const String _title = 'Flutter Code Sample';

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: _title,
      home: MyStatefulWidget(),
    );
  }
}

class MyStatefulWidget extends StatefulWidget {
  const MyStatefulWidget({Key? key}) : super(key: key);

  @override
  State<MyStatefulWidget> createState() => _MyStatefulWidgetState();
}

class _MyStatefulWidgetState extends State<MyStatefulWidget> {
  int _selectedIndex = 0;
  static const TextStyle optionStyle =
      TextStyle(fontSize: 30, fontWeight: FontWeight.normal, color: Colors.white);
  static const List<Widget> _widgetOptions = <Widget>[
    Text(
      'Index 0: Search',
      style: optionStyle,
    ),
    Text(
      'Index 1: Profile',
      style: optionStyle,
    ),
    Text(
      'Index 2: Offers Today',
      style: optionStyle,
    ),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('BottomNavigationBar Demo'),
        backgroundColor: Colors.deepPurple,
      ),
      body: Column(
        children: [
          Expanded(child: Container()),
          Center(
            // ignore: prefer_const_constructors
            child: Text("Can you see the Bottom Navigation Bar ",
            textAlign: TextAlign.center,
            style: TextStyle(
              color: Colors.white,
              fontSize: 40.0,
              fontStyle: FontStyle.normal, 
          ),  
    )),
     Expanded(child: Container()),
    Center(
        child: _widgetOptions.elementAt(_selectedIndex),
        //child: Text("The selected button is " +$(_widgetOptions.elementAt(_selectedIndex))
      ),
        Expanded(child: Container()),
        ],
        
        
        
        ),



      bottomNavigationBar: BottomNavigationBar(
        backgroundColor: Colors.deepPurple,
        unselectedItemColor:Colors.cyan,
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.search_rounded),
            label: 'Search',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.account_circle_rounded),
            label: 'Profile',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.local_offer_rounded),
            label: 'Offers',
          ),
        ],
        currentIndex: _selectedIndex,
        selectedItemColor: Colors.pink[100],
        onTap: _onItemTapped,
      ),
      backgroundColor: Colors.cyan,
      // persistentFooterButtons: <Widget>[
      //   Icon(Icons.apps),
      //   //Icon(Icons.more_horiz),
      //   Icon(Icons.share),
      //   Icon(Icons.email_outlined),
      //   Icon(Icons.help_center_rounded),
        
      //   Container(
          
      //     width: 500,
      //     child: Text(
      //       'I am the Footer',
      //       textAlign: TextAlign.center,
      //       style: TextStyle(
      //         color: Colors.white,
      //         fontSize: 20.0,
      //         fontStyle: FontStyle.italic,
      //         letterSpacing: 1,
      //       ),
      //     ),
      //   )]
    );
  }
}
