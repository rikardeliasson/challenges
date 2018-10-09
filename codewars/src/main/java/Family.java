import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Person {
    Person(String name) {
        this.name = name;
        this.gender = "";
        this.parents = new ArrayList<>();
    }

    String name;
    String gender;
    List<String> parents;
}

public class Family {
    HashMap<String, Person> nameMap = new HashMap<>();
    List<String> ancestors = new ArrayList<>();
    List<String> descendants = new ArrayList<>();
    boolean sexChanged = false;
    public boolean male(String name) {
        // Brand new person
        if(!nameMap.containsKey(name)) {
            nameMap.put(name, new Person(name));
            setMale(name);
            calculateAndAssignGenderForAllParents();
            while(sexChanged) {
                calculateAndAssignGenderForAllParents();
            }
            return true;
        }
        // Determine already existing persons sex
        else {
            // This person has kids, try to deduce the gender of this parent
            calculateAndAssignGenderForAllParents();
            while(sexChanged) {
                calculateAndAssignGenderForAllParents();
            }
            // Still no gender? Must be a single parent still. Make this guy a male!
            if(!hasGender(name)) {
                setMale(name);
                calculateAndAssignGenderForAllParents();
                while(sexChanged) {
                    calculateAndAssignGenderForAllParents();
                }
                return true;
            }
            // Something went horribly wrong. This guy became a woman somehow..
            if(isFemale(name)) {
                calculateAndAssignGenderForAllParents();
                return false;
            }
            // Either already a male or correctly calculated into one
            if(isMale(name)) {
                calculateAndAssignGenderForAllParents();
                while(sexChanged) {
                    calculateAndAssignGenderForAllParents();
                }
                return true;
            }
        }
        calculateAndAssignGenderForAllParents();
        while(sexChanged) {
            calculateAndAssignGenderForAllParents();
        }
        // This person doesn't exist and doesn't doesn't exist... just return if this is a family or not
        return isFamily();
    }
    public boolean isMale(String name) {
        if (nameMap.containsKey(name) && nameMap.get(name).gender.equals("male")) {
            return true;
        }
        return false;
    }
    public boolean female(String name) {
        // Brand new person, just label as a female
        if(!nameMap.containsKey(name)) {
            nameMap.put(name, new Person(name));
            setFemale(name);
            calculateAndAssignGenderForAllParents();
            while(sexChanged) {
                calculateAndAssignGenderForAllParents();
            }
            return true;
        }
        // Determine already existing persons sex
        else {
            // This person has kids, try to deduce the gender of this parent
            calculateAndAssignGenderForAllParents();
            while(sexChanged) {
                calculateAndAssignGenderForAllParents();
            }

            // Still no gender? Must be a single parent still. Let´s make an honest female out of this woman!
            if(!hasGender(name)) {
                setFemale(name);
                calculateAndAssignGenderForAllParents();
                while(sexChanged) {
                    calculateAndAssignGenderForAllParents();
                }
                return true;
            }
            // Something went horribly wrong. This woman became a man somehow..
            if(isMale(name)) {
                calculateAndAssignGenderForAllParents();
                while(sexChanged) {
                    calculateAndAssignGenderForAllParents();
                }
                return false;
            }
            // Either already a male or correctly calculated into one
            if(isFemale(name)) {
                calculateAndAssignGenderForAllParents();
                while(sexChanged) {
                    calculateAndAssignGenderForAllParents();
                }
                return true;
            }
        }
        calculateAndAssignGenderForAllParents();
        while(sexChanged) {
            calculateAndAssignGenderForAllParents();
        }
        // This person doesn't exist and doesn't doesn't exist... just return if this is a family or not
        return isFamily();
    }
    public boolean isFemale(String name) {

        if(nameMap.containsKey(name) && nameMap.get(name).gender.equals("female")) {
            return true;
        }
        return false;
    }
    public boolean setParentOf(String childName, String parentName) {
        // Really...
        if(childName.equals(parentName)) {
            System.out.println("FALSE1");
            return false;
        }
        // Already a relation..
        if(getParentsOf(childName).contains(parentName)) {
            System.out.println("TRUE1");
            return true;
        }
        if(getParentsOf(childName).size() == 2) {
            if(getParentsOf(childName).contains(parentName)) {
                System.out.println("TRUE2");
                return true;
            }
            System.out.println("FALSE2");
            return false;
        }
        // Kid doesn't exist! Create kid! (gender yet tbd)
        if(!nameMap.containsKey(childName)) {
            nameMap.put(childName, new Person(childName));
            // If the parent is also a new person
            if(!nameMap.containsKey(parentName)) {
                nameMap.put(parentName, new Person(parentName));
            }
            // Also give the kid a parent. No need to check for other parents since the kid was just created
            nameMap.get(childName).parents.add(parentName);
            System.out.println("TRUE3");
            return true;
        }
        // The kid is already in the family
        else if (nameMap.containsKey(childName)){

            // Does the intended parent exist? Let´s make sure! (Gender yet tbd)
            if(!nameMap.containsKey(parentName)) {
                nameMap.put(parentName, new Person(parentName));
            }

            if(isOnlySecondGenerationIncest(childName, parentName)) {
                System.out.println("TRUE4");
                return true;
            }
            //Are they already a family?
            /*ancestors.clear();
            getAllAncestorsOf(parentName);
            if(ancestors.contains(childName)) {
                System.out.println("child is ancestor");
                return false;
            }
            */
            /*
            ancestors.clear();
            getAllAncestorsOf(childName);
            if(ancestors.contains(parentName)) {
                System.out.println("parent is ancestor");
                return false;
            }
            */

            descendants.clear();
            getAllDescendants(childName);
            if(descendants.contains(parentName)) {
                System.out.println("child: " + childName + " parent: " + parentName + " is descendant");
                System.out.println(descendants.toString());
                return false;
            }

            /*
            descendants.clear();
            getAllDescendants(parentName);
            if(descendants.contains(childName)) {
                System.out.println("child is descendant");
                return false;
            }
            */

            if(!nameMap.get(childName).parents.isEmpty()) {
                Person parent = nameMap.get(getParentsOf(childName).get(0));
                if(!parent.gender.equals("") && parent.gender.equals(nameMap.get(parentName).gender)) {
                    System.out.println("FALSE3");
                    return false;
                }
            }

            // Also give the kid a parent.
            nameMap.get(childName).parents.add(parentName);

            // Make sure a male and a female are this kids parents
            calculateAndAssignGenderForAllParents();
            if(!isFamily()) {
                System.out.println("Same sexes NOOOOOOOOOOOOOO");
                return false;
            }
            System.out.println("TRUE5");
            return true;
        }
        System.out.println("FALSE4");
        return false;
    }
    public List<String> getParentsOf(String name) {
        List<String> parents = new ArrayList<>();
        if(nameMap.containsKey(name)) {
            parents = nameMap.get(name).parents;
            Collections.sort(parents);
        }
        return parents;
    }
    public List<String> getChildrenOf(String parent) {
        List<String> children = new ArrayList<>();
        nameMap.keySet().stream().forEach(person -> {
            if(nameMap.get(person).parents.contains(parent)) {
                children.add(person);
            }
        });
        Collections.sort(children);
        return children;
    }

    // Calculates whether parents are of different sexes. In this instance that makes a family.
    public boolean isFamily() {
        for(String name : nameMap.keySet()) {
            Person person = nameMap.get(name);
            List<String> parents = person.parents;
            if(!parents.isEmpty() && parents.size() == 2) {
                if((isMale(parents.get(0)) && isMale(parents.get(1))) || (isFemale(parents.get(0)) && isFemale(parents.get(1)))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void getAllDescendants(String name) {
        if(!getChildrenOf(name).isEmpty()) {
            for(String child : getChildrenOf(name)) {
                descendants.add(child);
                getAllDescendants(child);
            }
        }
    }

    public void getAllAncestorsOf(String name) {
        if(!getParentsOf(name).isEmpty()) {
            for(String parent : getParentsOf(name)) {
                ancestors.add(parent);
                getAllAncestorsOf(parent);
            }
        }
    }

    public void calculateAndAssignGenderForAllParents() {
        sexChanged = false;
        for(String name : nameMap.keySet()) {
            calculateAndAssignGenderForParentsOf(name);
        }
    }

    public void calculateAndAssignGenderForParentsOf(String name) {
        Person person = nameMap.get(name);
        List<String> parents = person.parents;
        if (!parents.isEmpty() && parents.size() == 2) {
            if (isMale(parents.get(0)) && !hasGender(parents.get(1))) {
                setFemale(parents.get(1));
                sexChanged = true;
            }
            else if (isFemale(parents.get(0)) && !hasGender(parents.get(1))) {
                setMale(parents.get(1));
                sexChanged = true;
            }
            else if (isMale(parents.get(1)) && !hasGender(parents.get(0))) {
                setFemale(parents.get(0));
                sexChanged = true;
            }
            else if (isFemale(parents.get(1)) && !hasGender(parents.get(0))) {
                sexChanged = true;
                setMale(parents.get(0));
            }
        }
    }

    public boolean isOnlySecondGenerationIncest(String childName, String parentName) {
        Person child = nameMap.get(childName);
        if(!child.parents.isEmpty()) {
            Person otherParent = nameMap.get(child.parents.get(0));
            if(!otherParent.parents.isEmpty()) {
                Person thirdParent = nameMap.get(otherParent.parents.get(0));
                if(!thirdParent.parents.isEmpty()) {
                    Person incestParent = nameMap.get(thirdParent.parents.get(0));
                    if(incestParent.name.equals(parentName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasGender(Person person) {
        return !person.gender.equals("");
    }
    public boolean hasGender(String name) {
        return hasGender(nameMap.get(name));
    }
    public void setMale(String name) {
        nameMap.get(name).gender = "male";
    }
    public void setFemale(String name) {
        nameMap.get(name).gender = "female";
    }
    public boolean noOneHasGender() {
        for(String name : nameMap.keySet()) {
            if(hasGender(nameMap.get(name))) {
                return false;
            }
        }
        return true;
    }
}