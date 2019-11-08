# An Xtext adapter for Henshin

The plugins in this repository allow Henshin modules, rules, nodes etc to be referenced directly from any Xtext-based language. To do this, you must:

1. Add `uk.ac.kcl.inf.henshinsupport` and `org.eclipse.emf.henshin.model` to the dependencies of your Xtext language plugin (and potentially your test plugin).
2. Add `uk.ac.kcl.inf.henshinsupport.ui` to the dependencies of your language's `.ui` plugin.
3. Add `referencedResource = "platform:/resource/org.eclipse.emf.henshin.model/model/henshin.genmodel"` to the `StandardLanguage` block in your `.mwe2` file.
4. Add `import "http://www.eclipse.org/emf/2011/Henshin" as henshin` to your `.xtext` file.
5. Use `[henshin::Module]` etc in your grammar to reference Henshin meta-classes. 

By default, links have no name in Henshin. To allow them to be referenced nonetheless, the plugins generate names following the grammar rule below:

```
LinkName :
	"[" ID "->" ID ":" ID "]"
;
```

The first ID is the name of the source node, the second the name of the target node, while the third is the name of the `EReference`. This naming scheme can be imported into any class in your own code by statically importing `uk.ac.kcl.inf.util.henshinsupport.NamingHelper`. In an Xtend class, it is recommended to import the class as an extension.
  
