# CrystalLeader

[![Paper 1.21.8](https://img.shields.io/badge/Paper-1.21.8-3498db?logo=minecraft)](https://papermc.io)
[![License](https://img.shields.io/badge/License-GPL--3.0-blue)](LICENSE)
[![Issues](https://img.shields.io/github/issues/your-username/CrystalLeader)](https://github.com/your-username/CrystalLeader/issues)

> **原汁原味的 2b2t 水晶 PVP 训练场**  
> 专为无政府风格服务器打造的管理插件，完美复刻 2b2t 服务器粗粝、无规则的水晶战斗体验 —— 无保护、无仁慈、纯技术。

![水晶 PVP 战斗实况](https://via.placeholder.com/800x400/2c3e50/ffffff?text=2b2t%E9%A3%8E%E6%A0%BC%E6%B0%B4%E6%99%B6PVP%E8%AE%AD%E7%BB%83%E5%9C%BA)  
*无出生点保护 · 无安全区 · 只有你、水晶与混沌*

## 🌐 设计哲学

受传奇无政府服务器 **2b2t** 启发，CrystalLeader 坚守真正的无政府主义游戏精神：

- ✅ **零人工保护** —— 死亡即失去一切，没有“复活补偿”
- ✅ **不禁出生点蹲守** —— 蹲点是合法战术，适应或死亡
- ✅ **允许自由破坏** —— 摧毁基地、填埋岩浆、挖穿地形 —— 这就是游戏的一部分
- ✅ **纯技术导向战斗** —— 不干扰合法水晶技巧（瞬秒、甩晶、杆晶）
- ✅ **玩家自治生态** —— 依靠社区声誉与报复机制自我调节，而非插件强制

> *“在 2b2t，唯一的规则就是没有规则。CrystalLeader 将这一哲学带入你的训练场。”*

## ⚔️ 核心特性

### 水晶战斗系统
- **原版水晶物理** —— 爆炸击退与伤害精准匹配 1.21.8 原版行为
- **瞬时水晶重生** —— 可配置重生时间（默认 0.8 秒），保持战斗流畅性
- **无限制放置/破坏** —— 不对黑曜石放置/破坏施加人工限制
- **NBT 数据保留** —— 水晶重生时保留自定义名称/可见性等 NBT 信息

### 无政府优先设计
- **无出生点保护** —— 在出生点被杀？那是你自己的问题
- **不禁战斗中退出** —— 你可以退出游戏，但社区会记住你
- **死亡物品全掉落** —— 死亡 = 永久损失（测试环境可配置关闭）
- **可破坏训练场** —— 玩家可摧毁黑曜石基地、岩浆陷阱、水道 —— 这是战术的一部分

### 最小干预式管理
- **静默监控** —— 仅记录水晶战斗事件，绝不干扰游戏进程
- **死亡数据分析** —— 追踪 K/D 比、水晶使用频率、热门战斗区域
- **大规模破坏预警（可选）** —— 仅在超大规模破坏（如 10000+ 方块）时通知管理员，**绝不自动回档**
- **玩家声誉系统** —— 基于社区反馈的可信度评分（如诬陷他人外挂将降低声誉）

### 训练场管理
- **多训练场支持** —— 通过 `/crystalleader create <名称>` 定义无限训练区域
- **世界边界限制** —— 防止战斗蔓延至非战斗世界
- **资源缓慢再生（默认关闭）** —— 核心区域黑曜石/岩浆可缓慢再生（关闭以保持真实无政府体验）
- **观战模式** —— `/crystal spectate <玩家>` 无声观战高端水晶对决（对战斗者不可见）

## 📥 安装指南

1. **运行环境要求**
    - Paper 1.21.8（[下载](https://papermc.io/downloads#Paper-1.21.8)）
    - Java 21+
    - ❌ **不兼容 Folia** —— 本插件依赖单线程物理引擎以保证水晶击退一致性

2. **安装步骤**
   ```bash
   # 停止服务器
   ./stop.sh

   # 将插件放入 plugins 目录
   cp CrystalLeader-1.0.jar 你的服务器/plugins/

   # 启动服务器生成配置文件
   ./start.sh
   ```

3. **首次配置（plugins/CrystalLeader/config.yml）**
   ```yaml
   anarchy-mode: true          # 启用真·无政府模式（无任何保护）
   crystal-respawn-delay: 0.8  # 水晶重生延迟（秒），推荐 0.5-2.0
   death-item-loss: true       # 死亡掉落全部物品（真无政府核心）
   arena-worlds:
     - crystal_pvp             # 训练场所在世界名称
   ```

## 🧭 指令与权限

| 指令 | 说明 | 权限 |
|------|------|------|
| `/crystalleader create <名称>` | 定义新训练场边界 | `crystalleader.admin.create` |
| `/crystalleader list` | 查看所有训练场 | `crystalleader.user` |
| `/crystal spectate <玩家>` | 观战指定玩家 | `crystalleader.spectate` |
| `/crystal stats` | 查看个人 K/D 与水晶使用统计 | `crystalleader.user` |
| `/crystalleader reload` | 重载配置（无需重启） | `crystalleader.admin.reload` |

> 🔑 **权限哲学**：极简权限设计。秉承无政府精神，绝大多数操作**无需权限** —— 玩家通过社区自治实现自我约束。

## ⚠️ 无政府真实性关键配置

```yaml
# plugins/CrystalLeader/config.yml
# 若追求原汁原味 2b2t 体验，请勿修改以下配置：
anarchy-mode: true
death-item-loss: true
prevent-spawn-camping: false    # 允许出生点蹲守
combat-log-punishment: none     # 不自动惩罚战斗中退出
auto-rollback-grief: false      # 不自动回档破坏行为
```

## 🌍 训练场搭建指南

1. 创建名为 `crystal_pvp` 的新世界（或自定义名称）
2. **手动搭建**黑曜石基地 —— 无自动生成（破坏与重建是游戏的一部分）
3. 定义训练场边界：
   ```mcfunction
   /crystalleader create spawn_area
   # 左键点击两点定义区域范围
   ```
4. **手动放置**末地水晶 —— 无自动放置
5. 混沌开始 🔥

## 📜 开源协议

GPL-3.0 —— 因为真正的无政府代码应当永远自由，供社区自由修改与传播。

## ❓ 常见问题

**Q：为何不集成反作弊？**  
A：合法水晶技巧（瞬秒、甩晶）常被误判为作弊。我们相信玩家社区能自我净化 —— 发现作弊者？在社区曝光，而非依赖插件封禁。

**Q：能否开启出生点保护？**  
A：技术上可以（配置中设为 `true`），但你将失去 2b2t 的灵魂。蹲点是合法战术 —— 适应它，或死于它。

**Q：玩家把整个训练场拆了怎么办？**  
A：这正是精髓所在。真正的无政府主义意味着训练场随玩家互动而演化。共同重建，或在废墟上继续厮杀。

**Q：为何不支持 Folia？**  
A：Folia 的区域多线程会破坏原版水晶击退一致性与物理行为。真实的水晶战斗必须运行于单线程环境。

## 🙏 致谢

- 灵感源自 **2b2t** 社区及其对无政府主义的极致坚持
- 水晶战斗机制研究自 [2b2t.org](https://2b2t.org) 游戏录像档案
- 特别致敬水晶 PVP 先驱：**FitMC**、**Shubble**、**Skeppy**

---

> 💀 *“2b2t 唯一的规则就是没有规则。如果你接受不了，滚去玩儿童服务器。”* —— 2b2t 老兵
>
> **CrystalLeader** —— 献给那些渴望体验真实无政府混沌战斗的玩家。

---

⚠️ **警告**：本插件**故意不提供任何安全网**。玩家会遭遇不公平死亡，基地会被摧毁，物品将永久丢失。如果你追求“公平”或“平衡”的体验，此插件不适合你。拥抱混沌 —— 或者别玩。