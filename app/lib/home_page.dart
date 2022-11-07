import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import './widgets/card_illuvial.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container();
  }

  @override
  State<HomePage> createState() => _HomePageState();
}

class Illuvial {
  final String name;
  final String class_name;
  final String affinity_name;
  final Color backgroundColor;
  final String image;

  Illuvial(
      {required this.name,
      required this.class_name,
      required this.affinity_name,
      required this.backgroundColor,
      required this.image});
}

getIlluvialCards(List<Illuvial> illuvials) {
  return illuvials
      .map(
        (item) => Container(
            margin: const EdgeInsets.all(5.0),
            padding: const EdgeInsets.all(5.0),
            width: 170,
            decoration: BoxDecoration(
                color: item.backgroundColor,
                borderRadius: BorderRadius.circular(20)),
            child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Container(
                        padding: const EdgeInsets.all(2.0),
                        child: Text(
                          item.name,
                          style: const TextStyle(
                            color: Colors.white,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ),
                      Container(
                        padding: const EdgeInsets.all(2.0),
                        child: Text(
                          item.affinity_name,
                          textAlign: TextAlign.right,
                          style: const TextStyle(
                              color: Colors.white, fontSize: 12),
                        ),
                      ),
                      Container(
                        padding: const EdgeInsets.all(2.0),
                        child: Text(
                          item.class_name,
                          textAlign: TextAlign.left,
                          style: const TextStyle(
                              color: Colors.white, fontSize: 12),
                        ),
                      )
                    ],
                  ),
                  Container(
                      child: Image.asset(item.image, width: 75, height: 75)),
                ])),
      )
      .toList();
}

class _HomePageState extends State<HomePage> {
  int currentPage = 0;

  List<Illuvial> illuvials = [
    Illuvial(
        name: "Scoriox",
        class_name: 'Arcenite',
        affinity_name: 'Magma',
        backgroundColor: const Color.fromRGBO(190, 80, 79, 1),
        image: 'assets/images/Scoriox.png'),
    Illuvial(
        name: "Titanor",
        class_name: 'Collosusis',
        affinity_name: 'Granite',
        backgroundColor: const Color.fromRGBO(162, 120, 184, 1),
        image: 'assets/images/Titanor.png'),
    Illuvial(
        name: "Scoriox",
        class_name: 'Arcenite',
        affinity_name: 'Magma',
        backgroundColor: const Color.fromRGBO(190, 80, 79, 1),
        image: 'assets/images/Scoriox.png'),
    Illuvial(
        name: "Titanor",
        class_name: 'Collosusis',
        affinity_name: 'Granite',
        backgroundColor: const Color.fromRGBO(162, 120, 184, 1),
        image: 'assets/images/Titanor.png'),
    Illuvial(
        name: "Scoriox",
        class_name: 'Arcenite',
        affinity_name: 'Magma',
        backgroundColor: const Color.fromRGBO(190, 80, 79, 1),
        image: 'assets/images/Scoriox.png'),
    Illuvial(
        name: "Titanor",
        class_name: 'Collosusis',
        affinity_name: 'Granite',
        backgroundColor: const Color.fromRGBO(162, 120, 184, 1),
        image: 'assets/images/Titanor.png'),
    Illuvial(
        name: "Scoriox",
        class_name: 'Arcenite',
        affinity_name: 'Magma',
        backgroundColor: const Color.fromRGBO(190, 80, 79, 1),
        image: 'assets/images/Scoriox.png'),
    Illuvial(
        name: "Titanor",
        class_name: 'Collosusis',
        affinity_name: 'Granite',
        backgroundColor: const Color.fromRGBO(162, 120, 184, 1),
        image: 'assets/images/Titanor.png'),
    Illuvial(
        name: "Scoriox",
        class_name: 'Arcenite',
        affinity_name: 'Magma',
        backgroundColor: const Color.fromRGBO(190, 80, 79, 1),
        image: 'assets/images/Scoriox.png'),
    Illuvial(
        name: "Titanor",
        class_name: 'Collosusis',
        affinity_name: 'Granite',
        backgroundColor: const Color.fromRGBO(162, 120, 184, 1),
        image: 'assets/images/Titanor.png'),
    Illuvial(
        name: "Scoriox",
        class_name: 'Arcenite',
        affinity_name: 'Magma',
        backgroundColor: const Color.fromRGBO(190, 80, 79, 1),
        image: 'assets/images/Scoriox.png'),
    Illuvial(
        name: "Titanor",
        class_name: 'Collosusis',
        affinity_name: 'Granite',
        backgroundColor: const Color.fromRGBO(162, 120, 184, 1),
        image: 'assets/images/Titanor.png'),
    Illuvial(
        name: "Scoriox",
        class_name: 'Arcenite',
        affinity_name: 'Magma',
        backgroundColor: const Color.fromRGBO(190, 80, 79, 1),
        image: 'assets/images/Scoriox.png'),
    Illuvial(
        name: "Titanor",
        class_name: 'Collosusis',
        affinity_name: 'Granite',
        backgroundColor: const Color.fromRGBO(162, 120, 184, 1),
        image: 'assets/images/Titanor.png'),
    Illuvial(
        name: "Scoriox",
        class_name: 'Arcenite',
        affinity_name: 'Magma',
        backgroundColor: const Color.fromRGBO(190, 80, 79, 1),
        image: 'assets/images/Scoriox.png'),
    Illuvial(
        name: "Titanor",
        class_name: 'Collosusis',
        affinity_name: 'Granite',
        backgroundColor: const Color.fromRGBO(162, 120, 184, 1),
        image: 'assets/images/Titanor.png')
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Home Page'),
        ),
        body: Center(
          child: SingleChildScrollView(
              physics: const ClampingScrollPhysics(),
              child: Padding(
                padding: const EdgeInsets.symmetric(
                  horizontal: 15,
                ),
                child: Flexible(
                  child:
                      Wrap(spacing: 1, children: getIlluvialCards(illuvials)),
                ),
              )),
        ));
  }
}
