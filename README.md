# Java Objects as Components (JOaC)

This is a small project demonstrating a novel component model where Java objects can be used as algebraic (like) components.
This is made possible through the use of the generic 'object' data type to store atomic (singular) and composit (combined) components, as well
as typical component based composition mechanisms such as sequencers, selectors and a new machanism known as a 'reflector' which employs
the use of reflection in a modular fashion.

## Getting Started with JOaC

Working with JOaC is as simple as creating an array of objects of type Object, creating an instructional array (which will tell the
composition class how and which objects to call depending on if a selector or sequencer is used), and finally passing both arrays to the
desired composition tool. For example, a sequencer would look like so:
```
Object array_of_objects[] = {Object1, Object2, Object3};
int object_sequence[] = {1, 2, 3}; // this can be changed to select a custom sequence
Sequencer ObjectSequencer = new Sequencer(array_of_objects, object_sequence);
```
Or, in the case of a selector:
```
Object array_of_objects[] = {Object1, Object2, Object3};
String object_cases[] = {"a", "b", "c"};
Selector ObjectSelector = new Selector(array_of_objects, object_cases);
```

## Model Nature and Behaviour

The nature of this model means that objects must have an interface named 'interfaceMethod' such that its functionality can be properly
executed. The composition objects also themselves have this method such that they can be composed again into further compositions, which
allows for a heirarchical calling structure that is either pre-determined during design (selecting the sequence or case during object
creation), or in the case of the selector can be changed at run time by using the 'chooseCase' method to select a specific case (if
left blank the chosen case will be used, if no case is chosen at all, the first object will be selected).

This model is also capable of passing data up and down its heirarchical structure through the use of the atomic and composit components'
arguments (args), which are required. Having the composit model's composition tools behave similarly to that of an atomic component means
that multiple objects can be composed into one singular object, allowing for complex, multi-composed algorithms to be easily passed
around inside your application much like a component but run-time exclusive. If a composition class were to be exported as a JAR with
its referenced classes, said JAR could be used as a repository based component containing specifically composed classes which could be
used with other components to easily create larger families of software applications.

Of course, this model is not without its limitations. Having each component/object behave and interface similarly means that certain
functionality of Java is limited, or has to be implemented in a long winded fashion. However it could be argued that if a component of
software is created properly, one would never have to edit or create it again and could be re-used infinitely in other applications, thus
saving time overall. Another very prominent issue with this method of wiritng software is that reflection is very commonly used when
compositng objects. By resolving objects at run-time in this manner, a considerable performance overhead is applied (as to how
considerable is yet to be tested).

## Given Example and Tests

The implementation example in this project takes the form of a very simple SQL interface application, in which the various actions that
can be taken (READ, INSERT, UPDATE, DELETE, etc.) have taken form as atomic components in the components package. Instances of these
components are then created in the ComposedComponents class (where objects ending with the letter A are atomic (singular) components,
and objects ending with the letter C are composed (multiple) for easier understanding in this implementation). Once fully composed,
the top-most composit component's interface method is called and the application runs as you'd expect. Where this example is small
and basic, it proves to show how different components containing individual functionality can be composed together into one object/component and still be easily used. It should be noted that the tools required to create composite components can be found in the 'composition' package. A flowchart diagram of this implementation can be seen below:

![A Flowchart Diagram](https://github.com/domfarr98/Java-Objects-as-Components/blob/master/Flowchart.png)

The unit tests given are fairly basic and only stand to ensure that components are being composed properly without error.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.
