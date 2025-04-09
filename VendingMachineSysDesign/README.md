This Design Problem follows 2 main patterns:
- State Pattern (Behavioral Pattern)
- Singleton Pattern  (Creation Pattern)

State Pattern involves:
- Creation of an Interface for all states - VendingMachineState
- Implementation of State classes - IdleState, ReadyState, DispenseState
- Each State class contains:
  - a shared instance of VendingMachine, which is passed into the State's constructor.
  - implementations of methods/actions happen in that state. 
- VendingMachineClass has a method called changeState() to move between states.