-- 코드를 입력하세요
SELECT CART_ID
FROM CART_PRODUCTS
WHERE NAME IN ('Milk')
    AND CART_ID IN (
    SELECT CART_ID
    FROM CART_PRODUCTS
    WHERE NAME IN ('Yogurt'))
ORDER BY CART_ID;