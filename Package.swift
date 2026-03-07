// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorRawbt",
    platforms: [.iOS(.v15)],
    products: [
        .library(
            name: "CapacitorRawbt",
            targets: ["RawBtPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "8.0.0")
    ],
    targets: [
        .target(
            name: "RawBtPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/RawBtPlugin"),
        .testTarget(
            name: "RawBtPluginTests",
            dependencies: ["RawBtPlugin"],
            path: "ios/Tests/RawBtPluginTests")
    ]
)