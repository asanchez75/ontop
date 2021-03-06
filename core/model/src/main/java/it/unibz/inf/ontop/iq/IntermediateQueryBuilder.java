package it.unibz.inf.ontop.iq;

import java.util.Optional;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.exception.IntermediateQueryBuilderException;
import it.unibz.inf.ontop.iq.node.BinaryOrderedOperatorNode;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
import it.unibz.inf.ontop.iq.node.QueryNode;
import it.unibz.inf.ontop.model.atom.DistinctVariableOnlyDataAtom;

/**
 * TODO: describe
 *
 * Can create only one intermediateQuery (to be used once).
 */
public interface IntermediateQueryBuilder {

    void init(DistinctVariableOnlyDataAtom projectionAtom, ConstructionNode rootConstructionNode)
            throws IntermediateQueryBuilderException;

    /**
     * When the parent is NOT a BinaryAsymetricOperatorNode
     */
    void addChild(QueryNode parentNode, QueryNode child) throws IntermediateQueryBuilderException;

    /**
     * When the parent is a BinaryAsymetricOperatorNode.
     */
    void addChild(QueryNode parentNode, QueryNode child, BinaryOrderedOperatorNode.ArgumentPosition position)
            throws IntermediateQueryBuilderException;

    /**
     * For commodity
     */
    void addChild(QueryNode parentNode, QueryNode child,
                  Optional<BinaryOrderedOperatorNode.ArgumentPosition> optionalPosition)
            throws IntermediateQueryBuilderException;


    IntermediateQuery build() throws IntermediateQueryBuilderException;

    ConstructionNode getRootConstructionNode() throws IntermediateQueryBuilderException;

    ImmutableList<QueryNode> getSubNodesOf(QueryNode node) throws IntermediateQueryBuilderException;

    IntermediateQueryFactory getFactory();
}
