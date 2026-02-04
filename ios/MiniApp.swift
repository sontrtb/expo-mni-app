//
//  MiniApp.swift
//  learn_ios_uikit
//
//  Created by Pham Hong on 4/2/26.
//
import UIKit
import WebKit

class MiniApp: UIView {

    private var webView: WKWebView!

    override init(frame: CGRect) {
        super.init(frame: frame)
        setupView()
        loadURL()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupView()
        loadURL()
    }

    private func setupView() {
        // Khởi tạo WKWebView
        webView = WKWebView(frame: .zero)
        webView.translatesAutoresizingMaskIntoConstraints = false

        addSubview(webView)

        // Auto Layout full màn hình view
        NSLayoutConstraint.activate([
            webView.topAnchor.constraint(equalTo: topAnchor),
            webView.bottomAnchor.constraint(equalTo: bottomAnchor),
            webView.leadingAnchor.constraint(equalTo: leadingAnchor),
            webView.trailingAnchor.constraint(equalTo: trailingAnchor)
        ])
    }

    private func loadURL() {
        guard let url = URL(string: "https://www.apple.com") else { return }
        let request = URLRequest(url: url)
        webView.load(request)
    }
}
