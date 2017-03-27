# prim-step
Java based demonstration of Minimum Spanning Tree Prim algorithm using HTML5 Canvas, Javascript and AJAX.

I present here a Java based demonstration of the Prim minimum spanning tree algorithm.

The algorithm itself is implemented in Java, Javascript is only used for initialization and display on Canvas.

First an undirected graph is randomly created and its largest connected component is extracted (Java side).

Then a minimum spanning tree is build stepwise (Java side) and the graph is redrawn at each step (browser side).

When deployed on Tomcat the context root is minimum-spanning-tree.

For a demonstration of the Kruskal minimum spanning tree algorithm please visit these repositories:

https://github.com/dubersfeld/kruskal-anim

https://github.com/dubersfeld/kruskal-step

Dominique Ubersfeld, Cachan, France
