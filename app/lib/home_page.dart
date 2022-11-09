import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'dart:convert';
import 'package:app/iilluvial_modal.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container();
  }

  @override
  State<HomePage> createState() => _HomePageState();
}

getIlluvialCards(List<IlluvialDataModal> illuvials) {
  return illuvials
      .map(
        (item) => Container(
            margin: const EdgeInsets.all(5.0),
            padding: const EdgeInsets.all(5.0),
            width: 170,
            decoration: BoxDecoration(
                color: const Color.fromRGBO(190, 80, 79, 1),
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
                          item.affinityName,
                          textAlign: TextAlign.right,
                          style: const TextStyle(
                              color: Colors.white, fontSize: 12),
                        ),
                      ),
                      Container(
                        padding: const EdgeInsets.all(2.0),
                        child: Text(
                          item.className,
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

Future<List<IlluvialDataModal>> readJson() async {
  final String response =
      await rootBundle.loadString('assets/json/illuvials.json');
  final data = await json.decode(response) as List<dynamic>;
  return data.map((e) => IlluvialDataModal.fromJson(e)).toList();
}

class _HomePageState extends State<HomePage> {
  int currentPage = 0;

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
                  child: FutureBuilder(
                    future: readJson(),
                    builder: (context, data) {
                      if (data.hasError) {
                        return Center(child: Text("${data.error}"));
                      } else if (data.hasData) {
                        var items = data.data as List<IlluvialDataModal>;
                        return Flexible(
                          child: Wrap(
                              spacing: 1, children: getIlluvialCards(items)),
                        );
                      } else {
                        return Center(
                          child: CircularProgressIndicator(),
                        );
                      }
                    },
                  ))),
        ));
  }
}
