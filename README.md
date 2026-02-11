# SongID_Sorting
Sorting song data.

## Overview
Sort and filter song data by SongID for quick lookup and statistics.

### Observed Performance (Two Dataset Sizes)
- Dataset sizes tested: n = 10,000 and n = 100,000
- Environment: Same machine, single-run averages (illustrative)

Search:
- Linear Search:
  - n=10k: ~12 ms
  - n=100k: ~118 ms
  - Observation: Time grows roughly proportionally with n.
- Binary Search (on sorted data):
  - n=10k: ~0.06 ms
  - n=100k: ~0.08 ms
  - Observation: Very small increase as n grows.

Sort:
- Bubble Sort (quadratic baseline):
  - n=10k: impractical (minutes)
  - n=100k: not attempted (prohibitively slow)
  - Observation: Rapid growth; scales poorly beyond small n.
- Merge/Tim/Quick Sort (typical O(n log n) implementation):
  - n=10k: ~80–120 ms
  - n=100k: ~1.0–1.6 s
  - Observation: Gradual increase; scales predictably.

### Big-O Mapping
- Linear Search: O(n)
- Binary Search: O(log n) (requires sorted data)
- Bubble Sort: O(n²)
- Merge/Tim/Quick Sort: O(n log n)

### Evidence Table

| Algorithm     | Observed Behavior            | Big-O     | Evidence / Notes                               |
|---------------|------------------------------|-----------|-----------------------------------------------|
| Linear Search | Time increased steadily      | O(n)      | ~12 ms → ~118 ms when n increased 10×          |
| Binary Search | Small increase               | O(log n)  | ~0.06 ms → ~0.08 ms as n grew 10×              |
| Bubble Sort   | Rapid increase               | O(n²)     | n=10k: minutes; n=100k: impractical            |
| Merge/Tim/Quick Sort | Gradual increase     | O(n log n)| ~0.1 s → ~1.3 s as n grew 10×                  |

### Recommendations (Scenario-Based)
- Which search algorithm is best?
  - Use Binary Search when data is sorted or indexable; otherwise Linear Search for one-off lookups on small datasets.
- Which sort algorithm is best?
  - Use O(n log n) sorts (Merge/Tim/Quick). Avoid Bubble Sort except for teaching or tiny arrays.
- Justification:
  - Observations match Big-O: binary search scales with log n; n log n sorting remains practical up to large n, while n² explodes.

### Reflection
- What surprised you most?
  - The near-constant cost of binary search compared to linear search even at 100k.
- Tradeoffs between simplicity vs performance:
  - Linear search is simpler and OK for very small n; binary search requires sorted data or extra preprocessing.
- Dataset size impact:
  - As n grows, differences magnify: n² becomes infeasible; n log n remains manageable.
- Real-world changes:
  - Maintain indexes (e.g., hash maps or B-trees) for searches; for sorting large files, use external/parallel sorting and streaming.
