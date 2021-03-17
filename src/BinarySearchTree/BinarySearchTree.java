package BinarySearchTree;

public class BinarySearchTree {
    public void InOrderTraverse(Node root)
    {
        if(root==null)
        {
            return;
        }
        InOrderTraverse(root.getLeft());
        System.out.println(root.getKey());
        InOrderTraverse(root.getRight());
    }

    public Node TreeSearch(Node root, int k)   //递归方法查找结点
    {
        if( root==null || k==root.getKey())
        {
            return root;
        }
        if(k< root.getKey())
            return TreeSearch(root.getLeft(),k);
        else
            return TreeSearch(root.getRight(),k);
    }

    public Node IterativeTreeSearch(Node root, int k)    //循环迭代查找结点
    {
        Node temp=root;
        while(temp!=null&&k!= temp.getKey())
        {
            if(k<temp.getKey())
            {
                temp=temp.getLeft();
            }
            else
            {
                temp=temp.getRight();
            }
        }
        return  temp;
    }

    public Node Minimum(Node root)
    {
        Node temp=root;
        while(temp!=null)
        {
            temp=temp.getLeft();
        }
        return temp;
    }

    public Node Maximum(Node root)
    {
        Node temp=root;
        while(temp!=null)
        {
            temp=temp.getRight();
        }
        return temp;
    }

    public Node Tree_Successor(Node node)   //查找结点的中序遍历的后继结点
    {
        if(node.getRight()!=null)
        {
            return Maximum(node);
        }
        Node parent=node.getParent();
        Node temp=node;
        while(parent!=null && node==parent.getRight())    //左子节点比双亲结点先遍历，所以左子节点是前驱
        {
            temp=parent;
            parent=temp.getParent();
        }
        return temp;
    }

    public void Node_Insert(Node root, Node k)
    {
        if(root.getKey()==Integer.MIN_VALUE)
        {
            root.setKey(k.getKey());
            return;
        }
        Node parent = null;
        Node temp = root;

        while(temp!=null)
        {
            parent=temp;

            if(k.getKey()< temp.getKey())
            {
                temp=temp.getLeft();
            }
            else temp=temp.getRight();
        }

        k.setParent(parent);
        if(parent==null)
        {
            root=k;
        }
        else if(k.getKey()<parent.getKey())
        {
            parent.setLeft(k);
        }
        else parent.setRight(k);
    }

    public void Delete(Node root,Node z)
    {
        if(z.getLeft()==null&&z.getRight()!=null)
        {
            TransPlant(root,z,z.getRight());
        }
        else if(z.getRight()==null&&z.getLeft()!=null)
        {
            TransPlant(root,z,z.getLeft());
        }
        else if(z.getLeft()==null&&z.getRight()==null)
        {
            TransPlant(root,z,null);
        }
        else {
            Node parent=Minimum(z.getRight());
            if(parent.getParent()!=z)
            {
                TransPlant(root,parent,parent.getRight());
                parent.setRight(z.getRight());
                parent.getRight().setParent(parent);
            }
            TransPlant(root,z,parent);
            parent.setLeft(z.getLeft());
            parent.getLeft().setParent(parent);
        }
    }

    private void TransPlant(Node root, Node u, Node v)
    {
        if(u.getParent()==null)
        {
            root=v;
        }
        else if(u.getParent().getLeft()==u)
        {
            u.getParent().setLeft(v);
        }
        else u.getParent().setRight(v);

        if(u!=null&&v!=null)
        {
            v.setParent(u.getParent());
        }
    }
}
