#!/bin/bash

# MartianPay Java SDK - 无需Maven的运行脚本
# 这个脚本可以在没有Maven的情况下编译和运行Java代码

set -e

# 获取脚本所在目录
PROJECT_ROOT="$(cd "$(dirname "$0")" && pwd)"
cd "$PROJECT_ROOT"

echo "=== MartianPay Java SDK - 无需Maven运行 ==="
echo ""

# 创建输出目录
mkdir -p build/classes
mkdir -p build/examples
mkdir -p build/lib

echo "步骤 1: 下载依赖包..."
# 如果没有依赖包，需要手动下载
GSON_JAR="build/lib/gson-2.10.1.jar"
OKHTTP_JAR="build/lib/okhttp-4.12.0.jar"
OKIO_JAR="build/lib/okio-3.6.0.jar"
KOTLIN_STDLIB_JAR="build/lib/kotlin-stdlib-1.9.10.jar"
SLF4J_API_JAR="build/lib/slf4j-api-2.0.9.jar"
SLF4J_SIMPLE_JAR="build/lib/slf4j-simple-2.0.9.jar"

if [ ! -f "$GSON_JAR" ]; then
    echo "  下载 Gson..."
    curl -L "https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar" -o "$GSON_JAR"
fi

if [ ! -f "$OKHTTP_JAR" ]; then
    echo "  下载 OkHttp..."
    curl -L "https://repo1.maven.org/maven2/com/squareup/okhttp3/okhttp/4.12.0/okhttp-4.12.0.jar" -o "$OKHTTP_JAR"
fi

if [ ! -f "$OKIO_JAR" ]; then
    echo "  下载 Okio..."
    curl -L "https://repo1.maven.org/maven2/com/squareup/okio/okio-jvm/3.6.0/okio-jvm-3.6.0.jar" -o "$OKIO_JAR"
fi

if [ ! -f "$KOTLIN_STDLIB_JAR" ]; then
    echo "  下载 Kotlin Stdlib..."
    curl -L "https://repo1.maven.org/maven2/org/jetbrains/kotlin/kotlin-stdlib/1.9.10/kotlin-stdlib-1.9.10.jar" -o "$KOTLIN_STDLIB_JAR"
fi

if [ ! -f "$SLF4J_API_JAR" ]; then
    echo "  下载 SLF4J API..."
    curl -L "https://repo1.maven.org/maven2/org/slf4j/slf4j-api/2.0.9/slf4j-api-2.0.9.jar" -o "$SLF4J_API_JAR"
fi

if [ ! -f "$SLF4J_SIMPLE_JAR" ]; then
    echo "  下载 SLF4J Simple..."
    curl -L "https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/2.0.9/slf4j-simple-2.0.9.jar" -o "$SLF4J_SIMPLE_JAR"
fi

echo "✓ 依赖包准备完成"
echo ""

CLASSPATH="$GSON_JAR:$OKHTTP_JAR:$OKIO_JAR:$KOTLIN_STDLIB_JAR:$SLF4J_API_JAR:$SLF4J_SIMPLE_JAR"

echo "步骤 2: 编译SDK源代码..."
find src/main/java -name "*.java" > sources.txt
javac -d build/classes -cp "$CLASSPATH" @sources.txt
rm sources.txt
echo "✓ SDK编译完成"
echo ""

echo "步骤 3: 编译Examples..."
find examples/src/main/java -name "*.java" > examples_sources.txt
javac -d build/examples -cp "build/classes:$CLASSPATH" @examples_sources.txt
rm examples_sources.txt
echo "✓ Examples编译完成"
echo ""

echo "步骤 4: 启动交互式示例菜单..."
echo ""
java -cp "build/classes:build/examples:$CLASSPATH" com.martianpay.examples.ExamplesMain

echo ""
echo "=== 完成 ==="
