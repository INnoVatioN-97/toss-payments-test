package com.example.toss_payments_test.domain.free_lancers;

import com.example.toss_payments_test.domain.free_lancers.response.FreeLancersListResponse;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FreeLancersCustomRepositoryImpl implements FreeLancersCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<FreeLancersListResponse> findMany(Integer page, Integer size, Sort sort) {
        QFreeLancers qFreeLancers = QFreeLancers.freeLancers;
        return queryFactory
                .select(Projections.constructor(FreeLancersListResponse.class, qFreeLancers.name,
                        qFreeLancers.searchCount,
                        Expressions.stringTemplate(
                                "DATE_FORMAT({0}, '%Y%m%d')", qFreeLancers.createdAt)))
                .from(qFreeLancers)
                .orderBy(getOrderSpecifier(sort).stream().toArray(OrderSpecifier[]::new))
                .limit((long) page * size)
                .offset(size)
                .fetch();
    }

    private List<OrderSpecifier> getOrderSpecifier(Sort sort) {
        List<OrderSpecifier> orders = new ArrayList<>();

        sort.stream().forEach(order -> {
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;

            PathBuilder orderByExpression = new PathBuilder(FreeLancers.class, "freeLancers");
            orders.add(new OrderSpecifier(direction, orderByExpression.get(order.getProperty())));
        });

        return orders;
    }


}
