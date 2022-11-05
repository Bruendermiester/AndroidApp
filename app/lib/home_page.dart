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

  Illuvial(
      {required this.name,
      required this.class_name,
      required this.affinity_name});
}

Widget getIlluvialCards(List<Illuvial> illuvials) {
  return Row(
      children: illuvials
          .map((item) => Container(
                child: Column(
                  children: [
                    Container(
                      padding: const EdgeInsets.all(20.0),
                      child: Text(
                        item.name,
                      ),
                    ),
                    Container(
                      padding: const EdgeInsets.all(10.0),
                      child: Text(item.affinity_name),
                    )
                  ],
                ),
              ))
          .toList());
}

class _HomePageState extends State<HomePage> {
  int _counter = 0;
  int currentPage = 0;

  List<Illuvial> illuvials = [
    Illuvial(name: "Scoriox", class_name: 'Arcenite', affinity_name: 'Magma'),
    Illuvial(
        name: "Titanor", class_name: 'Collosusis', affinity_name: 'Granite')
  ];

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Home Page'),
      ),
      body: Center(
        child: Container(
          margin: const EdgeInsets.all(30.0),
          padding: const EdgeInsets.all(3.0),
          height: 150,
          decoration: BoxDecoration(
              border: Border.all(color: Colors.black),
              borderRadius: BorderRadius.circular(10)),
          alignment: Alignment.center,
          child: Wrap(
            spacing: 8.0,
            runSpacing: 4.0,
            children: <Widget>[getIlluvialCards(illuvials)],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ),
    );
  }
}
