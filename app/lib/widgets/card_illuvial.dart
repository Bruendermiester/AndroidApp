// import 'package:flutter/cupertino.dart';
// import 'package:flutter/material.dart';

// class CardIlluvial extends StatefulWidget {
//    final String buttonText;
//    final Function onPressed;

//    CardIlluvial ({required this.onPressed, this.buttonText = 'defaultString'})

//    @override
//    _CustomWidgetState createState() => _CustomWidgetState();
// }


// class _CustomWidgetState extends State<CardIlluvial> {

//  @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(
//         title: const Text('Home Page'),
//       ),
//       body: Center(
//         child: Container(
//           margin: const EdgeInsets.all(30.0),
//           padding: const EdgeInsets.all(3.0),
//           height: 150,
//           decoration: BoxDecoration(
//               border: Border.all(color: Colors.black),
//               borderRadius: BorderRadius.circular(10)),
//           alignment: Alignment.center,
//           child: Column(
//             children: [
//               Container(
//                 padding: const EdgeInsets.all(20.0),
//                 child: const Text(
//                   'You have pushed the button this many times:',
//                 ),
//               ),
//               Container(
//                 padding: const EdgeInsets.all(10.0),
//                 child: const Text('test'
//                 ),
//               )
//             ],
//           ),
//         ),
//       ),
//       floatingActionButton: FloatingActionButton(
//         onPressed: (() {
          
//         }),
//         tooltip: 'Increment',
//         child: const Icon(Icons.add),
//       ),
//     );
//   }
// }