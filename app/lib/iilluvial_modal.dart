class IlluvialDataModal {
  String name = '';
  String image = '';
  String affinityName = '';
  String className = '';
  int size = 0;
  int set = 0;
  int stage = 0;
  int mp = 0;
  int tier = 0;
  String omega = '';
  int health = 0;
  int omegaPower = 0;
  int damage = 0;
  int grit = 0;
  int resolve = 0;
  int attackRange = 0;
  int precision = 0;
  int physicalAttack = 0;
  int attackSpeed = 0;
  double movement = 0.0;
  int critAmp = 0;
  int energyAttack = 0;
  int energyCost = 0;
  int initialEnergy = 0;
  int dodge = 0;

  IlluvialDataModal(
      this.name,
      this.image,
      this.affinityName,
      this.className,
      this.size,
      this.set,
      this.stage,
      this.mp,
      this.tier,
      this.omega,
      this.health,
      this.omegaPower,
      this.damage,
      this.grit,
      this.resolve,
      this.attackRange,
      this.precision,
      this.physicalAttack,
      this.attackSpeed,
      this.movement,
      this.critAmp,
      this.energyAttack,
      this.energyCost,
      this.initialEnergy,
      this.dodge);

  IlluvialDataModal.fromJson(Map<String, dynamic> json) {
    name = json['name'];
    image = json['image'];
    affinityName = json['type'];
    className = json['class'];
    size = json['size'];
    set = json['set'];
    stage = json['stage'];
    mp = json['mp'];
    tier = json['tier'];
    omega = json['omega'];
    health = json['health'];
    omegaPower = json['omegaPower'];
    damage = json['damage'];
    grit = json['grit'];
    resolve = json['resolve'];
    attackRange = json['attackRange'];
    precision = json['precision'];
    physicalAttack = json['physicalAttack'];
    attackSpeed = json['attackSpeed'];
    movement = json['movement'];
    critAmp = json['critAmp'];
    energyAttack = json['energyAttack'];
    energyCost = json['energyCost'];
    initialEnergy = json['initialEnergy'];
    dodge = json['dodge'];
  }
}
