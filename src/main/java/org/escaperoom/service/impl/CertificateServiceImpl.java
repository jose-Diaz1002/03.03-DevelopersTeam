package org.escaperoom.service.impl;

import org.escaperoom.model.AchievementCertificate;
import org.escaperoom.service.interfaces.CertificateService;

public class CertificateServiceImpl implements CertificateService {
    @Override
    public AchievementCertificate generateCertificate(String playerName, String description) {
        return new AchievementCertificate(); // Crear y guardar
    }
}