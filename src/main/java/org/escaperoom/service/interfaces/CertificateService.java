package org.escaperoom.service.interfaces;

import org.escaperoom.model.AchievementCertificate;

public interface CertificateService {
    /*
     * Generates a certificate for a player who has completed an escape room.
     *
     * @param playerId The ID of the player.
     * @param escapeRoomId The ID of the escape room completed.
     * @return A string representing the generated certificate.
     */
   // String generateCertificate(String playerId, String escapeRoomId);

    AchievementCertificate generateCertificate(String playerName, String description);

}
