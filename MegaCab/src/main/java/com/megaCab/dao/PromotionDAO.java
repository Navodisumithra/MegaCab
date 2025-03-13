package com.megaCab.dao;

import com.megaCab.Database.DBConnection;
import com.megaCab.JavaFiles.Promotion;

import java.sql.*;
import java.util.Optional;

public class PromotionDAO {

        private DBConnection dbConnection;

        public PromotionDAO() {
            this.dbConnection = new DBConnection();
        }

        /**
         * Fetches a promotion by its promo code.
         *
         * @param promoCode The code of the promotion to fetch.
         * @return An Optional containing the Promotion object if found, or empty if not found.
         */
        public Optional<Promotion> getPromotionByCode(String promoCode) {
            String sql = "SELECT * FROM promotions WHERE promoCode = ?";
            try (Connection conn = dbConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, promoCode);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    Promotion promotion = new Promotion();
                    promotion.setPromoCode(rs.getString("promoCode"));
                    promotion.setDiscountPercentage(rs.getDouble("discountPercentage"));
                    return Optional.of(promotion);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        }

        /**
         * Adds a new promotion to the database.
         *
         * @param promotion The Promotion object to add.
         * @return True if the promotion was successfully added, false otherwise.
         */
        public boolean addPromotion(Promotion promotion) {
            String sql = "INSERT INTO promotions (promoCode, discountPercentage) VALUES (?, ?)";
            try (Connection conn = dbConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, promotion.getPromoCode());
                pstmt.setDouble(2, promotion.getDiscountPercentage());

                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        /**
         * Updates an existing promotion in the database.
         *
         * @param promotion The Promotion object to update.
         * @return True if the promotion was successfully updated, false otherwise.
         */
        public boolean updatePromotion(Promotion promotion) {
            String sql = "UPDATE promotions SET discountPercentage = ? WHERE promoCode = ?";
            try (Connection conn = dbConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setDouble(1, promotion.getDiscountPercentage());
                pstmt.setString(2, promotion.getPromoCode());

                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        /**
         * Deletes a promotion from the database.
         *
         * @param promoCode The code of the promotion to delete.
         * @return True if the promotion was successfully deleted, false otherwise.
         */
        public boolean deletePromotion(String promoCode) {
            String sql = "DELETE FROM promotions WHERE promoCode = ?";
            try (Connection conn = dbConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, promoCode);

                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

}
