import 'package:flutter/material.dart';
import 'package:flutter_project/MeterialAppExp.dart';  

void main() {
  runApp(MyHomePage("FlutterDemo"));
}

  
class MyHomePage extends StatelessWidget {    
  MyHomePage(this.title) ;
  // This widget is the home page of your application.    
  final String title;    
    
  @override    
  Widget build(BuildContext context) {    
    return MaterialApp(
          home: Scaffold(    
        appBar: AppBar(    
          title: Text(this.title),    
        ),    
        body: Center(    
          child: Text('Hello World',textAlign: TextAlign.center,       
              style: new TextStyle(fontWeight: FontWeight.bold, fontSize:50
              )   )    
        ), 
           
           backgroundColor: Colors.purple[200],
           //FloatingActionButton(onPressed: (){}
           
           
      ),
    );    
  }    
}    