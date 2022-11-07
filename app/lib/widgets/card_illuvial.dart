// import 'package:flutter/cupertino.dart';
// import 'package:flutter/material.dart';

// class CardIlluvial extends StatefulWidget {
//    final Function onPressed;
//     final String name;
//     final String class_name;
//     final String affinity_name;
//     final Color backgroundColor;
//     final String image;

//    CardIlluvial (
//     {required this.onPressed, 
//       required this.name,
//       required this.class_name,
//       required this.affinity_name,
//       required this.backgroundColor,
//       required this.image }
//     )

//    @override
//    IlluvialCard createState() => IlluvialCard();
// }


// class IlluvialCard extends State<CardIlluvial> {

//  @override
//   Widget build(BuildContext item) {
//     return Container(
//             margin: const EdgeInsets.all(5.0),
//             padding: const EdgeInsets.all(5.0),
//             width: 17,
//             decoration: BoxDecoration(
//                 color: item.backgroundColor,
//                 borderRadius: BorderRadius.circular(20)),
//             child: Row(
//                 mainAxisAlignment: MainAxisAlignment.spaceBetween,
//                 children: [
//                   Column(
//                     crossAxisAlignment: CrossAxisAlignment.start,
//                     children: [
//                       Container(
//                         padding: const EdgeInsets.all(2.0),
//                         child: Text(
//                           item.name,
//                           style: const TextStyle(
//                             color: Colors.white,
//                             fontWeight: FontWeight.bold,
//                           ),
//                         ),
//                       ),
//                       Container(
//                         padding: const EdgeInsets.all(2.0),
//                         child: Text(
//                           item.affinity_name,
//                           textAlign: TextAlign.right,
//                           style: const TextStyle(
//                               color: Colors.white, fontSize: 12),
//                         ),
//                       ),
//                       Container(
//                         padding: const EdgeInsets.all(2.0),
//                         child: Text(
//                           item.class_name,
//                           textAlign: TextAlign.left,
//                           style: const TextStyle(
//                               color: Colors.white, fontSize: 12),
//                         ),
//                       )
//                     ],
//                   ),
//                   Container(
//                       child: Image.asset(item.image, width: 75, height: 75)),
//                 ]));
//   }
// }