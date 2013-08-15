package edu.stanford.nlp.mt.chinese;

import junit.framework.TestCase;
/**
 * @author Rob Voigt
 */
public class PreorderingTest extends TestCase {

  ChineseSourcePreordering preorder;

  public void setUp() {
    preorder = new ChineseSourcePreordering();
  }

  public void testPatterns() {
    assertEquals("Wrong preordering for VP(PP:VP)",
            "(TOP (IP (VP (VP (VV ����) (QP (OD ��ʮ))) (PP (P ��) (NP (NN ����) (NN ����))))))",
            ChineseSourcePreordering.preorder("(TOP (IP (VP (PP (P ��) (NP (NN ����) (NN ����))) (VP (VV ����) (QP (OD ��ʮ))))))"));
    
    assertEquals("Wrong preordering for VP(LCP:VP)",
            "(TOP (IP (VP (VP (VV ����) (NP (NN ����))) (NP (NT ����) (NT ����)))))",
            ChineseSourcePreordering.preorder("(TOP (IP (VP (NP (NT ����) (NT ����)) (VP (VV ����) (NP (NN ����))))))"));
    
    assertEquals("Wrong preordering for VP(NT:VP)",
            "(TOP (IP (VP (VP (VV ����)) (QP (CD ��) (CLP (M ��))))))",
            ChineseSourcePreordering.preorder("(TOP (IP (VP (QP (CD ��) (CLP (M ��))) (VP (VV ����)))))"));
    
    assertEquals("Wrong preordering for VP(QP:VP)",
            "(TOP (NP (NP (NN ����) (NN Ԯ��)) (DNP (PP (P ��) (NP (NR ��Ͳ�Τ))) (DEG ��))))",
            ChineseSourcePreordering.preorder("(TOP (NP (DNP (PP (P ��) (NP (NR ��Ͳ�Τ))) (DEG ��)) (NP (NN ����) (NN Ԯ��))))"));
    
    assertEquals("Wrong preordering for NP(CP:NP)",
            "(TOP (NP (NP (NN ����)) (DNP (NP (DP (DT ��) (CLP (M ��))) (NP (NN ����))) (DEG ��))))",
            ChineseSourcePreordering.preorder("(TOP (NP (DNP (NP (DP (DT ��) (CLP (M ��))) (NP (NN ����))) (DEG ��)) (NP (NN ����))))"));
    
  }
}
